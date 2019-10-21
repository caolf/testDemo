package com.zh.service;

import com.api.out.model.ShuZiZhenDongModel;
import com.zh.model.XYZ;

import java.util.ArrayList;
import java.util.List;

public class ShuZiZhengDongV2 {

    /**
     * Xg=（x- xk0）*9.8 / xk1
     * 计算xg
     * @param xyz
     * @param xyz0
     * @param xyz1
     * @return
     */
    public static XYZ calG(XYZ xyz,XYZ xyz0,XYZ xyz1) {
        double x = 0;
        double y = 0;
        double z = 0;
        final  double  XG=1;
        try {
            x = (xyz.getX() - xyz0.getX()) * XG / xyz1.getX();
            y = (xyz.getY() - xyz0.getY()) * XG / xyz1.getY();
            z = (xyz.getZ() - xyz0.getZ()) * XG / xyz1.getZ();
        } catch (Exception e) {
            throw new RuntimeException("x1,y1,z1均不可为0！");
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


    public static Double calSqe(XYZ result) {
        return Math.sqrt(Math.pow(result.getX(), 2) + Math.pow(result.getY(), 2) + Math.pow(result.getZ(), 2));
    }

    public static void calShuZiZheng(List<ShuZiZhenDongModel> shuZiZhenDongModelLists){
        List<XYZ> xyzList = calShuZiZhengStep1(shuZiZhenDongModelLists);
        for(int i=0,length=shuZiZhenDongModelLists.size();i<length;i++){
            getShuZiZhenDongResult(
                    shuZiZhenDongModelLists.get(i),
                    xyzList.get(i),
                    calSqe(xyzList.get(i)));//步骤三
        }

    }
    /**
     * 计算x y z
     * @param shuZiZhenDongModelLists
     * @return
     */
    public static List<XYZ> calShuZiZhengStep1(List<ShuZiZhenDongModel> shuZiZhenDongModelLists) {
        ShuZiZhenDongModel item = shuZiZhenDongModelLists.get(0);
        int nMax = shuZiZhenDongModelLists.size();
        int nMin = item.getnMin();
        Double ts = item.getTs();
        Double b = item.getB();

        List<XYZ> xyzList = new ArrayList<>();
        for (int i = 0, length = shuZiZhenDongModelLists.size(); i < length; i++) {
            ShuZiZhenDongModel model = shuZiZhenDongModelLists.get(i);
            xyzList.add(calG(
                    new XYZ(model.getX(),model.getY(),model.getZ()),
                    new XYZ(model.getX0(),model.getY0(),model.getZ0()),
                    new XYZ(model.getX1(),model.getY1(),model.getZ1())
                    ));//步骤一
        }

        XYZ diff = ShuZiZhengDongV2.calMaxMinDiff(xyzList);//步骤二

        return ShuZiZhengDongV2.calS(diff, ts, nMin, nMax, b);
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
