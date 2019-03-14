package com.zh.test.out;

import com.zh.enums.DecryptionEnm;
import com.zh.medol.DataFrame;
import com.zh.medol.ZhangLiData;
import com.zh.out.DecryptionUtil;
import org.junit.Assert;
import org.junit.Test;

public class DecryptionUtilTest {

    @Test
    public void calZhangLi() {
        ZhangLiData data = new ZhangLiData();
        data.setTime("2018,10,31,13,2,13,");
        data.setOldData(0.744629);
        DecryptionUtil.decryptionCal(DecryptionEnm.ZHANGLI,data);
        System.out.println(data.getNewData());
        Assert.assertEquals(new Double(6.633967455),data.getNewData());
    }
}
