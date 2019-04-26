package com.zh.medol;

public class WuDong extends XYZ {

    private double ts;
    private int N;
    private double x0;
    private double y0;
    private double z0;
    private double x1;
    private double y1;
    private double z1;
    private double b;

    public WuDong(String time, double x, double y, double z, double ts, int n, double x0, double y0, double z0, double x1, double y1, double z1, double b) {
        super(time, x, y, z);
        this.ts = ts;
        N = n;
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.b = b;
    }

    public double getTs() {
        return ts;
    }

    public void setTs(double ts) {
        this.ts = ts;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getZ0() {
        return z0;
    }

    public void setZ0(double z0) {
        this.z0 = z0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getZ1() {
        return z1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
