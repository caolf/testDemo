package com.zh.out;


import com.zh.medol.DataFrame;
import org.junit.Test;

public class DecryptionUtilTest {

    @Test
    public void calZhangLi() {
        DataFrame data = new DataFrame();
        data.setTime("2019-03-01");
        data.setOldData(1.5);
        DecryptionUtil.calZhangLi(data);
        System.out.println(data.getNewData());
    }
}
