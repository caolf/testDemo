package com.zh.service;

import com.zh.common.DataUtil;
import com.zh.medol.Galloping;
import com.zh.medol.PendulumAcceleration;
import com.zh.medol.RatchetAngle;
import com.zh.medol.ZhangLiData;

import java.util.Queue;

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
    public Galloping calGalloping(Queue<Galloping> gallopings) {
        if (gallopings == null || gallopings.size() == 0) {
            throw new RuntimeException("queue is empty!");
        }
        int N = 10;
        double ts = 0.1;
        if (gallopings.size() < 2 * N + 1) {
            return new Galloping();
        } else {
            Galloping a = gallopings.element();
            Galloping avg = mean(gallopings);
            Galloping ak = calAK(a, avg);
            Galloping p = calP(ak, ts);

            Galloping mid = getMidElement(gallopings);

            return midSubAvg(mid, avg);
        }

    }

    private Galloping midSubAvg(Galloping mid, Galloping avg) {
        return new Galloping(mid.getX() - avg.getX(), mid.getY() - avg.getY(), mid.getZ() - avg.getZ());
    }

    private Galloping getMidElement(Queue<Galloping> gallopings) {
        int i = 0;
        for (Galloping item : gallopings) {
            if (i == gallopings.size() / 2) {
                return new Galloping(item.getX(), item.getY(), item.getZ());
            }
        }
        return new Galloping();
    }

    private Galloping calP(Galloping ak, double ts) {
        Galloping p = new Galloping();

        return p;
    }

    private Galloping calAK(Galloping a, Galloping avg) {
        Galloping ak = new Galloping();
        ak.setX((a.getX() - avg.getX()) * 9.8 / a.getX());
        ak.setY((a.getY() - avg.getY()) * 9.8 / a.getY());
        ak.setZ((a.getZ() - avg.getZ()) * 9.8 / a.getZ());
        return ak;
    }


    private Galloping mean(Queue<Galloping> gallopings) {

        return new Galloping();
    }

}
