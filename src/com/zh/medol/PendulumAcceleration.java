package com.zh.medol;

import com.zh.common.NotProguard;

@NotProguard
public class PendulumAcceleration extends DataFrame {

    private Double newAcceleration;
    private Double oldAcceleration;
    private Double K0;
    private Double K1;

    public PendulumAcceleration(String time, Double oldAcceleration, Double k0, Double k1) {
        super();
        setTime(time);
        this.oldAcceleration = oldAcceleration;
        K0 = k0;
        K1 = k1;
    }

    public Double getNewAcceleration() {
        return newAcceleration;
    }

    public Double getOldAcceleration() {
        return oldAcceleration;
    }

    public Double getK0() {
        return K0;
    }

    public Double getK1() {
        return K1;
    }

    public void setNewAcceleration(Double newAcceleration) {
        this.newAcceleration = newAcceleration;
    }
}
