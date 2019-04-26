package com.zh.medol;

public class XYZ extends DataFrame {
    private double x;
    private double y;
    private double z;

    public XYZ(String time,double x, double y, double z) {
        super();
        this.setTime(time);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public XYZ() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public XYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
