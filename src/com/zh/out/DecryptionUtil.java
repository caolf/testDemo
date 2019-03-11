package com.zh.out;

import com.zh.medol.DataFrame;
import com.zh.service.Decryption;
import com.zh.service.DecryptionImp;

public class DecryptionUtil {
    private static Decryption decryption=new DecryptionImp();

    public static void calZhangLi(DataFrame dataFrame){
        try {
            decryption.calZhangLi(dataFrame);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
