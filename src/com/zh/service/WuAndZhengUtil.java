package com.zh.service;

import com.zh.medol.WuDong;
import com.zh.medol.XYZ;

import java.util.List;

public class WuAndZhengUtil {

    public static XYZ calG(WuDong wuDong) {
        double x = 0;
        double y = 0;
        double z = 0;
        try {
            x = (wuDong.getX() - wuDong.getX0()) * 9.8 / wuDong.getX1();
            y = (wuDong.getY() - wuDong.getY0()) * 9.8 / wuDong.getY1();
            z = (wuDong.getZ() - wuDong.getZ0()) * 9.8 / wuDong.getZ1();
        } catch (Exception e) {
            throw new RuntimeException("time:" + wuDong.getTime() + " : x1,y1,z1均不可为0！");
        }
        return new XYZ(x, y, z);
    }

    private static XYZ calMaxMinDiff(List<XYZ> gList) {
        if (gList == null || gList.size() <= 0)
            return null;
        double xMax = gList.get(0).getX();
        double yMax = gList.get(0).getY();
        double zMax = gList.get(0).getZ();

        double xMin = gList.get(0).getX();
        double yMin = gList.get(0).getY();
        double zMin = gList.get(0).getZ();

        for (int i = 1, length = gList.size(); i < length; i++) {
            if (gList.get(i).getX() > xMax) {
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

    private XYZ calS(XYZ c, Double ts, Double n, Double b) {
        Double tsNb = (ts * n / 6.28) * (ts * n / 6.28) * Math.sin(6.28 / (ts * ts * n)) * b;
        Double x = c.getX() * tsNb;
        Double y = c.getY() * tsNb;
        Double z = c.getZ() * tsNb;
        return  new XYZ(x,y,z);
    }

    private WuDong getResult(WuDong source,XYZ result){
        return  new WuDong(source.getTime(),result.getX(),result.getY(),result.getZ(),
                source.getTs(),source.getN(),source.getX0(),source.getY0(),
                source.getZ0(),source.getX1(),source.getY1(),source.getZ1(),source.getB());
    }


    private Double calSqe(XYZ result){
        return Math.sqrt(Math.pow(result.getX(),2)+Math.pow(result.getY(),2)+Math.pow(result.getZ(),2));
    }



}
