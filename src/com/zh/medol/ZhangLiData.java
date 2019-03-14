package com.zh.medol;

import com.sun.javafx.beans.annotations.NoInit;
import com.zh.common.NotProguard;

@NotProguard
public class ZhangLiData extends DataFrame {
    private String time;
    //张力（原始数据）
    private Double oldData;
    //张力（新数据）
    private Double newData;

    public Double getOldData() {
        return oldData;
    }

    public void setOldData(Double oldData) {
        this.oldData = oldData;
    }

    public Double getNewData() {
        return newData;
    }

    public void setNewData(Double newData) {
        this.newData = newData;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
