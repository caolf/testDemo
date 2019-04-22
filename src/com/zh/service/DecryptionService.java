package com.zh.service;

import com.zh.enums.DecryptionEnm;
import com.zh.medol.DataFrame;
import com.zh.medol.PendulumAcceleration;
import com.zh.medol.RatchetAngle;
import com.zh.medol.ZhangLiData;

public class DecryptionService {
    private static Decryption decryption = new DecryptionImp();

    public static void decryptionCal(DataFrame dataFrame) {
        if (dataFrame instanceof ZhangLiData) {
            decryption.calZhangLi((ZhangLiData) dataFrame);
        } else if(dataFrame instanceof RatchetAngle){
            decryption.calRatchetAngle((RatchetAngle) dataFrame);
        } else if(dataFrame instanceof PendulumAcceleration) {
            decryption.calPendulumAcceleration((PendulumAcceleration) dataFrame);
        }else{
            throw new RuntimeException("Params(type or dataFrame) are error!");
        }
    }
}
