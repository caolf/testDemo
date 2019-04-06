package com.zh.medol;

import com.zh.common.NotProguard;

@NotProguard
public class ZhangLiData extends DataFrame {
    private String time;
    //张力（原始数据）
    private Double oldData;
    //张力（新数据）
    private Double newData;

    public ZhangLiData() {
    }
    public ZhangLiData(String time, Double oldData) {
        this.time = time;
        this.oldData = oldData;
    }

    public String getTime() {
        return time;
    }

    public Double getOldData() {
        return oldData;
    }

    public Double getNewData() {
        return newData;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOldData(Double oldData) {
        this.oldData = oldData;
    }

    public void setNewData(Double newData) {
        this.newData = newData;
    }
}
