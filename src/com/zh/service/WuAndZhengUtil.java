package com.zh.service;

import com.api.out.model.ShuZiZhenDongModel;
import com.zh.model.GallopingModel;
import com.zh.model.VibrationModel;
import com.zh.model.XYZ;

import java.util.ArrayList;
import java.util.List;

public class WuAndZhengUtil {

    public static XYZ calG(GallopingModel gallopingModel) {
        double x = 0;
        double y = 0;
        double z = 0;
        try {
            x = (gallopingModel.getX() - gallopingModel.getX0()) * 9.8 / gallopingModel.getX1();
            y = (gallopingModel.getY() - gallopingModel.getY0()) * 9.8 / gallopingModel.getY1();
            z = (gallopingModel.getZ() - gallopingModel.getZ0()) * 9.8 / gallopingModel.getZ1();
        } catch (Exception e) {
            throw new RuntimeException("time:" + gallopingModel.getTime() + " : x1,y1,z1均不可为0！");
        }
        return new XYZ(x, y, z);
    }

    public static XYZ calMaxMinDiff(List<XYZ> gList) {
        if (gList == null || gList.size() <= 0)
            return null;
        double xMax = gList.get(0).getX();
        double yMax = gList.get(0).getY();
        double zMax = gList.get(0).getZ();

        double xMin = gList.get(0).getX();
        double yMin = gList.get(0).getY();
        double zMin = gList.get(0).getZ();

        for (int i = 1, length = gList.size(); i < length; i++) {

            if (Double.compare(gList.get(i).getX(), xMax) == 1) {
                xMax = gList.get(i).getX();
            }
            if (gList.get(i).getY() > yMax) {
                yMax = gList.get(i).getY();
            }
            if (gList.get(i).getZ() > zMax) {
                zMax = gList.get(i).getZ();
            }

            if (gList.get(i).getX() < xMin) {
                xMin = gList.get(i).getX();
            }
            if (gList.get(i).getY() < yMin) {
                yMin = gList.get(i).getY();
            }
            if (gList.get(i).getZ() < zMin) {
                zMin = gList.get(i).getZ();
            }

        }

        return new XYZ(xMax - xMin, yMax - yMin, zMax - zMin);

    }


    public static List<XYZ> calS(XYZ c, Double ts, int nMin, int nMax, Double b) {
        List<XYZ> xyzList = new ArrayList<>();
        Double tsn = (ts * nMin / 6.28) * (ts * nMin / 6.28);
        for (int i = 0; i < nMax; i++) {
            double t = i * ts;
            if (ts * nMin * t == 0) {
                xyzList.add(new XYZ(0, 0, 0));
            } else {
                Double tsNb = tsn * Math.sin(6.28 / (ts * nMin * t)) * b;
                Double x = c.getX() * tsNb;
                Double y = c.getY() * tsNb;
                Double z = c.getZ() * tsNb;
                xyzList.add(new XYZ(x, y, z));
            }
        }
        return xyzList;
    }


    public static void getGallopingResult(GallopingModel source, XYZ result) {
        source.setNewX(result.getX());
        source.setNewY(result.getY());
        source.setNewZ(result.getZ());
        XYZ xyzG = calG(source);
        source.setNewXg(xyzG.getX());
        source.setNewYg(xyzG.getY());
        source.setNewZg(xyzG.getZ());
    }

    public static void getVibrationResult(VibrationModel source, XYZ result, Double pf) {
        source.setNewX(result.getX());
        source.setNewY(result.getY());
        source.setNewZ(result.getZ());
        source.setPf(pf);
        XYZ xyzG = calG(source);
        source.setNewXg(xyzG.getX());
        source.setNewYg(xyzG.getY());
        source.setNewZg(xyzG.getZ());
        if (source.getTs() == 0.0) {
            source.setPinLv(0.0);
        } else {
            source.setPinLv(1 / source.getTs());
        }
    }

    public static Double calSqe(XYZ result) {
        return Math.sqrt(Math.pow(result.getX(), 2) + Math.pow(result.getY(), 2) + Math.pow(result.getZ(), 2));
    }


    public static List<XYZ> cal(List gallopingMedolList) {
        if (gallopingMedolList.get(0) instanceof GallopingModel) {
            GallopingModel item = (GallopingModel) gallopingMedolList.get(0);
            int nMax = gallopingMedolList.size();
            int nMin = item.getnMin();
            Double ts = item.getTs();
            Double b = item.getB();

            List<XYZ> xyzList = new ArrayList<>();
            for (int i = 0, length = gallopingMedolList.size(); i < length; i++) {
                xyzList.add(WuAndZhengUtil.calG((GallopingModel) gallopingMedolList.get(i)));
            }

            XYZ diff = WuAndZhengUtil.calMaxMinDiff(xyzList);

            return WuAndZhengUtil.calS(diff, ts, nMin, nMax, b);
        }
        return null;
    }

    /**
     * 振动舞动算法
     * 1.Xg=（x- xk0）*9.8 / xk1 计算xg
     * 2.Xc=xgmax- xgmin N个数计算最大最小值
     * 3.Xs= Xc * (TS*N / 6.28)2   * SIN(6.28 / TS*N*TS)* b        转换
     *
     * @param
     * @return
     */
//    public static List<XYZ> calNew(List gallopingMedolList) {
//        if (gallopingMedolList.get(0) instanceof GallopingModel) {
//            GallopingModel item = (GallopingModel) gallopingMedolList.get(0);
//            int nMax = item.getnMax() < gallopingMedolList.size() ? item.getnMax() : gallopingMedolList.size();
//            int nMin = item.getnMin();
//            Double ts = item.getTs();
//            Double b = item.getB();
//
//            //第一步
//            List<XYZ> xyzList = new ArrayList<>();
//            for (int i = 0, length = gallopingMedolList.size(); i < length; i++) {
//                xyzList.add(WuAndZhengUtil.calG((GallopingModel) gallopingMedolList.get(i)));
//            }
//
//            //第二步
//            if (nMax!= item.getnMax()){//数据个数小于nMax
//                XYZ diff = WuAndZhengUtil.calMaxMinDiff(xyzList);
//                return WuAndZhengUtil.calS(diff, ts, nMin, nMax, b);
//            }else {
//                List<XYZ> result = new ArrayList<>();
//                List<XYZ> NList= xyzList.subList(0,nMax);
//                for (int i=nMax,length=xyzList.size();i<length;i++){
//                    XYZ diff = WuAndZhengUtil.calMaxMinDiff(NList);
//                    result.add(WuAndZhengUtil.calSOfsinge(diff, ts, nMin, nMax, b));
//                    NList = NList.subList(1,nMax-1);
//                    NList.add(xyzList.get(i));
//                }
//                return result;
//            }
//
//
//
//        }
//        return null;
//    }
    public static List<XYZ> calShuZiZheng(List<ShuZiZhenDongModel> shuZiZhenDongModelLists) {
        ShuZiZhenDongModel item = shuZiZhenDongModelLists.get(0);
        int nMax = shuZiZhenDongModelLists.size();
        int nMin = item.getnMin();
        Double ts = item.getTs();
        Double b = item.getB();

        List<XYZ> xyzList = new ArrayList<>();
        for (int i = 0, length = shuZiZhenDongModelLists.size(); i < length; i++) {
            xyzList.add(new XYZ(shuZiZhenDongModelLists.get(i).getX(),
                    shuZiZhenDongModelLists.get(i).getY(),
                    shuZiZhenDongModelLists.get(i).getZ()));
        }

        XYZ diff = WuAndZhengUtil.calMaxMinDiff(xyzList);

        return WuAndZhengUtil.calS(diff, ts, nMin, nMax, b);
    }

    public static void getShuZiZhenDongResult(ShuZiZhenDongModel source, XYZ result, Double pf) {
        source.setNewX(result.getX());
        source.setNewY(result.getY());
        source.setNewZ(result.getZ());
        if (source.getTs() == 0.0) {
            source.setPinLv(0.0);
        } else {
            source.setPinLv(1 / source.getTs());
        }
        source.setNewXg(source.getX());
        source.setNewYg(source.getY());
        source.setNewZg(source.getZ());
        source.setZhenFu(pf);
    }
}
