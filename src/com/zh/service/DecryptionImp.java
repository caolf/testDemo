package com.zh.service;

import com.zh.common.DataUtil;
import com.zh.enums.DecryptionEnm;
import com.zh.medol.DataFrame;
import com.zh.medol.ZhangLiData;

public class DecryptionImp implements Decryption{

    @Override
    public void calZhangLi(ZhangLiData dataFrame) {
        Double newData=(DecrytionConstantData.ZHANGLIONE/DecrytionConstantData.ZHANGLITWO)*dataFrame.getOldData();
        dataFrame.setNewData(DataUtil.dataFomateByParam(newData,DecrytionConstantData.ZHANGLITHREE));
    }

}
