/**
 * @Author clf
 * @Date 2019/3/11
 * @Desc
 */
package com.zh.medol;
public class DataFrame {
    private String time;
    private Double oldData;
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
