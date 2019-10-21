package com.api.out.model;

import com.zh.common.NotProguard;

@NotProguard
public class ShuZiZhenDongModel {

    private double ts;
    private int nMax;
    private double x0;
    private double y0;
    private double z0;
    private double x1;
    private double y1;
    private double z1;
    private double b;
    private int nMin;
    private double x;
    private double y;
    private double z;

    private double newX;
    private double newY;
    private double newZ;

    //加速度
    private double newXg;
    private double newYg;
    private double newZg;

    //版本
    private String version;

    private Double pinLv;

    private Double zhenFu;

    public ShuZiZhenDongModel(double ts, int nMax,
                              double x0, double y0, double z0,
                              double x1, double y1, double z1,
                              double b, int nMin,
                              double x, double y, double z,
                              String version) {
        this.ts = ts;
        this.nMax = nMax;
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.b = b;
        this.nMin = nMin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.version = version;
    }

    public double getTs() {
        return ts;
    }

    public void setTs(double ts) {
        this.ts = ts;
    }

    public int getnMax() {
        return nMax;
    }

    public void setnMax(int nMax) {
        this.nMax = nMax;
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

    public int getnMin() {
        return nMin;
    }

    public void setnMin(int nMin) {
        this.nMin = nMin;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public double getNewZ() {
        return newZ;
    }

    public void setNewZ(double newZ) {
        this.newZ = newZ;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getPinLv() {
        return pinLv;
    }

    public void setPinLv(Double pinLv) {
        this.pinLv = pinLv;
    }

    public double getNewXg() {
        return newXg;
    }

    public void setNewXg(double newXg) {
        this.newXg = newXg;
    }

    public double getNewYg() {
        return newYg;
    }

    public void setNewYg(double newYg) {
        this.newYg = newYg;
    }

    public double getNewZg() {
        return newZg;
    }

    public void setNewZg(double newZg) {
        this.newZg = newZg;
    }

    public Double getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(Double zhenFu) {
        this.zhenFu = zhenFu;
    }
}
