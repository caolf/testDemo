package com.zh.out;

import com.zh.common.NotProguard;
import com.zh.enums.DecryptionEnm;
import com.zh.medol.DataFrame;
import com.zh.service.DecryptionService;

@NotProguard
public class DecryptionUtil {

    public static void decryptionCal(DecryptionEnm type,DataFrame dataFrame){
        try {
            DecryptionService.decryptionCal(type,dataFrame);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
