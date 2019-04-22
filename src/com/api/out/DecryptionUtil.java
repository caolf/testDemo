package com.api.out;

import com.zh.common.NotProguard;
import com.zh.medol.DataFrame;
import com.zh.service.DecryptionService;

@NotProguard
public class DecryptionUtil {

    public static void decryptionCal(DataFrame dataFrame){
        try {
            DecryptionService.decryptionCal(dataFrame);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
