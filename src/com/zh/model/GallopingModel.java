package com.zh.model;

import com.zh.common.NotProguard;

@NotProguard
public class GallopingModel extends XYZ {

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

    private double newX;
    private double newY;
    private double newZ;

    //加速度
    private double newXg;
    private double newYg;
    private double newZg;

    //版本
    private String version;


    public GallopingModel(String time, double x, double y, double z, double ts, int nMax, double x0, double y0, double z0, double x1, double y1, double z1, double b, int nMin) {
        super(time, x, y, z);
        this.ts = ts;
        this.nMax =nMax;
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.b = b;
        this.nMin = nMin;
    }

    public int getnMax() {
        return nMax;
    }

    public void setnMax(int nMax) {
        this.nMax = nMax;
    }

    public int getnMin() {
        return nMin;
    }

    public void setnMin(int nMin) {
        this.nMin = nMin;
    }

    public double getTs() {
        return ts;
    }

    public void setTs(double ts) {
        this.ts = ts;
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

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public void setNewZ(double newZ) {
        this.newZ = newZ;
    }

    public double getNewX() {
        return newX;
    }

    public double getNewY() {
        return newY;
    }

    public double getNewZ() {
        return newZ;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
