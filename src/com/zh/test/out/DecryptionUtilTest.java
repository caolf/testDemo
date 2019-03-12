package com.zh.test.out;


import com.zh.medol.DataFrame;
import com.zh.out.DecryptionUtil;
import org.junit.Assert;
import org.junit.Test;

public class DecryptionUtilTest {

    @Test
    public void calZhangLi() {
        DataFrame data = new DataFrame();
        data.setTime("2018,10,31,13,2,13,");
        data.setOldData(0.744629);
        DecryptionUtil.calZhangLi(data);
        System.out.println(data.getNewData());
        Assert.assertEquals(new Double(2.322998),data.getNewData());
    }
}
