package com.zh.model;

import com.zh.common.NotProguard;

@NotProguard
public class ZhangLiData extends DataFrame {
    //张力（原始数据）
    private Double oldData;
    //张力（新数据）
    private Double newData;

    public ZhangLiData() {
    }

    public ZhangLiData(String time, Double oldData) {
        super();
        setTime(time);
        this.oldData = oldData;
    }

    public void setNewData(Double newData) {
        this.newData = newData;
    }

    public Double getOldData() {
        return oldData;
    }

    public Double getNewData() {
        return newData;
    }

    public void setOldData(Double oldData) {
        this.oldData = oldData;
    }

}
