package com.zh.model;

import com.zh.common.NotProguard;

@NotProguard
public class VibrationModel extends GallopingModel {
    //振幅
    private Double pf;

    //频率
    private Double pinLv;


    public VibrationModel(String time, double x, double y, double z, double ts, int N, double x0, double y0, double z0, double x1, double y1, double z1, double b, int n) {
        super(time, x, y, z, ts, N, x0, y0, z0, x1, y1, z1, b, n);
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

    public Double getPinLv() {
        return pinLv;
    }

    public void setPinLv(Double pinLv) {
        this.pinLv = pinLv;
    }
}
