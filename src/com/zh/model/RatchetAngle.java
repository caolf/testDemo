package com.zh.model;

import com.zh.common.NotProguard;

@NotProguard
public class RatchetAngle extends DataFrame {

    private Double oldAngle;
    private Double newAngle;
    private Double K0;
    private Double K1;

    public RatchetAngle(String time, Double oldAngle, Double k0, Double k1) {
        super();
        setTime(time);
        this.oldAngle = oldAngle;
        K0 = k0;
        K1 = k1;
    }

    public Double getOldAngle() {
        return oldAngle;
    }

    public Double getNewAngle() {
        return newAngle;
    }

    public Double getK0() {
        return K0;
    }

    public Double getK1() {
        return K1;
    }

    public void setNewAngle(Double newAngle) {
        this.newAngle = newAngle;
    }
}
