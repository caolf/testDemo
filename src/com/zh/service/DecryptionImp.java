package com.zh.service;

import com.api.out.model.ShuZiZhenDongModel;
import com.zh.Util.FileUtil;
import com.zh.common.DataUtil;
import com.zh.enums.DecryptionEnm;
import com.zh.model.*;

import java.util.*;

public class DecryptionImp implements Decryption {

    @Override
    public void calZhangLi(ZhangLiData dataFrame) {
        Double newData = (DecrytionConstantData.ZHANGLIONE / DecrytionConstantData.ZHANGLITWO) * dataFrame.getOldData();
        dataFrame.setNewData(DataUtil.dataFomateByParam(newData, DecrytionConstantData.ZHANGLITHREE));
    }

    @Override
    public void calRatchetAngle(RatchetAngle dataFrame) {
        Double newData = Math.asin((dataFrame.getOldAngle() - dataFrame.getK0()) / dataFrame.getK1())
                * DecrytionConstantData.ANGLE
                / DecrytionConstantData.PAI;
        dataFrame.setNewAngle(DataUtil.dataFomateByParam(newData, DataUtil.FOMATE_FOUR));
    }

    @Override
    public void calPendulumAcceleration(PendulumAcceleration dataFrame) {
        Double newData = (dataFrame.getOldAcceleration() - dataFrame.getK0()) / dataFrame.getK1();
        dataFrame.setNewAcceleration(DataUtil.dataFomateByParam(newData, DataUtil.FOMATE_FOUR));
    }

    @Override
    public void calGalloping(String sourcePath, String resultPath) {
        //读取源数据
        List<SourceGalloping> sourceGallopings = new ArrayList<>();
        FileUtil.read(sourcePath, sourceGallopings, 1);
        //初始化参数
        final int N = 10;
        final double ts = 0.1;
        int length = 2 * N + 1;

        Queue<Galloping> gallopings = new ArrayDeque<>(length);
        Galloping v = new Galloping();
        Galloping p = new Galloping();

        int queueCount = 0;
        int index = 0;
        Iterator<SourceGalloping> it = sourceGallopings.iterator();
        while (it.hasNext()) {
            SourceGalloping current = it.next();
            //队满则出队，然后入队
            if (gallopings.size() >= length) {
                gallopings.poll();
                gallopings.offer(current);

                SourceGalloping a = current;
                Galloping avg = mean(gallopings);
                Galloping ak = calAK(a, avg);
                calV(v, ak, ts);
                calP(p, v, ts);

            } else {
                gallopings.offer(current);
                queueCount++;
                v = new Galloping();
                p = new Galloping();
            }

            System.out.println(index + "  A:" + current.toString() + "  V:" + v.toString() + " P:" + p.toString());
            changeSourceGallopingsToResult(sourceGallopings, p, index);
            index++;
        }

        FileUtil.write(resultPath, sourceGallopings);

    }

    //舞动算法
    @Override
    public void calGalloping(List<GallopingModel> gallopingModelList) {
        if (gallopingModelList == null && gallopingModelList.size() > 0) {
            throw new RuntimeException(DecryptionEnm.GALLOPING.toString() + ": 参数List不能为null且size大于0！");
        }

        List<XYZ> s = WuAndZhengUtil.cal(gallopingModelList);

        for(int i = 0, length = gallopingModelList.size(); i<length; i++){
            WuAndZhengUtil.getGallopingResult(gallopingModelList.get(i),s.get(i));
        }
    }

    //振动算法
    @Override
    public void calVibration(List<VibrationModel> vibrationMedolList) {

        if (vibrationMedolList == null && vibrationMedolList.size() > 0) {
            throw new RuntimeException(DecryptionEnm.VIBRATION.toString() + ": 参数List不能为null且size大于0！");
        }

        List<XYZ> s = WuAndZhengUtil.cal(vibrationMedolList);

        for(int i=0,length=vibrationMedolList.size();i<length;i++){
            WuAndZhengUtil.getVibrationResult(vibrationMedolList.get(i),s.get(i),WuAndZhengUtil.calSqe(s.get(i)));
        }
    }

    @Override
    public void calShuZiZhenDong(List<ShuZiZhenDongModel> shuZiZhenDongModelLists) {
        if (shuZiZhenDongModelLists == null && shuZiZhenDongModelLists.size() > 0) {
            throw new RuntimeException(DecryptionEnm.VIBRATION.toString() + ": 参数List不能为null且size大于0！");
        }

        ShuZiZhengDongV2.calShuZiZheng(shuZiZhenDongModelLists);
    }

    private void changeSourceGallopingsToResult(List<SourceGalloping> sourceGallopings, Galloping p, int index) {
        sourceGallopings.get(index).changeSourceGalloping(p);
    }

    private void calV(Galloping v, Galloping ak, double ts) {
        v.setX(v.getX() + ak.getX() * ts);
        v.setY(v.getY() + ak.getY() * ts);
        v.setZ(v.getZ() + ak.getZ() * ts);
    }


    private void calP(Galloping p, Galloping v, double ts) {
        p.setX(p.getX() + v.getX() * ts);
        p.setY(p.getY() + v.getY() * ts);
        p.setZ(p.getZ() + v.getZ() * ts);
    }

    private Galloping calAK(SourceGalloping a, Galloping avg) {
        Galloping ak = new Galloping();
        ak.setX((a.getX() - avg.getX()) * 9.8 / a.getX1());
        ak.setY((a.getY() - avg.getY()) * 9.8 / a.getY1());
        ak.setZ((a.getZ() - avg.getZ()) * 9.8 / a.getZ1());
        return ak;
    }


    private Galloping mean(Queue<Galloping> gallopings) {
        Galloping avg = new Galloping();
        int i = 0;

        for (Galloping it : gallopings) {
            avg.setX(avg.getX() + it.getX());
            avg.setY(avg.getY() + it.getY());
            avg.setZ(avg.getZ() + it.getZ());
        }
      /*  Iterator<Galloping> it = gallopings.iterator();
        while (it.hasNext()) {
            avg.setX(avg.getX() + it.next().getX());
            avg.setY(avg.getY() + it.next().getY());
            avg.setZ(avg.getZ() + it.next().getZ());
        }*/
        if (i != 0) {
            avg.setX(avg.getX() / i);
            avg.setY(avg.getY() / i);
            avg.setZ(avg.getZ() / i);
        }
        return avg;
    }

}
