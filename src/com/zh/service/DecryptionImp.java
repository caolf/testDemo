package com.zh.service;

import com.zh.common.DataUtil;
import com.zh.medol.DataFrame;

public class DecryptionImp implements Decryption{
    @Override
    public void calZhangLi(DataFrame dataFrame) {
        Double newData=(DecrytionConstantData.ZHANGLIONE/DecrytionConstantData.ZHANGLITWO)*1000*dataFrame.getOldData();
        dataFrame.setNewData(DataUtil.dataFomateByParam(newData,DecrytionConstantData.SIX));
    }
}
