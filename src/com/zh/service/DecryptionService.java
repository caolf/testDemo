package com.zh.service;

import com.zh.enums.DecryptionEnm;
import com.zh.medol.DataFrame;
import com.zh.medol.ZhangLiData;

public class DecryptionService {
    private static Decryption decryption = new DecryptionImp();

    public static void decryptionCal(DecryptionEnm type, DataFrame dataFrame) {
        if (DecryptionEnm.ZHANGLI.equals(type) && dataFrame instanceof ZhangLiData) {
            decryption.calZhangLi((ZhangLiData) dataFrame);
        } else {
            throw new RuntimeException("Params(type or dataFrame) are error!");
        }
    }
}
