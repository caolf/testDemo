package com.zh.model;

public class SourceGalloping extends Galloping {

    private double x1 ;
    private double y1;
    private double z1;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getZ1() {
        return z1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    public void changeSourceGalloping(Galloping p){
        this.setX(p.getX());
        this.setY(p.getY());
        this.setZ(p.getZ());
    }

    public SourceGalloping(double x, double y, double z, double x1, double y1, double z1) {
        super(x, y, z);
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
    }

    public SourceGalloping() {
    }

}
