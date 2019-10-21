package com.api.out;

import com.zh.common.NotProguard;
import com.zh.enums.DecryptionEnm;
import com.zh.model.DataFrame;
import com.zh.service.DecryptionService;

import java.util.List;

@NotProguard
public class DecryptionUtil {

    public static void decryptionCal(DataFrame dataFrame){
        try {
            DecryptionService.decryptionCal(dataFrame);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void decryptionCal(List datas ,DecryptionEnm decryptionEnm){
        if(DecryptionEnm.GALLOPING.equals(decryptionEnm)){
            DecryptionService.calGalloping(datas);
        }else if(DecryptionEnm.VIBRATION.equals(decryptionEnm)){
            DecryptionService.calVibration(datas);
        }else if(DecryptionEnm.SHUZIZHENDONG.equals(decryptionEnm)){
            DecryptionService.calShuZiZhenDong(datas);
        }else {
            throw new RuntimeException("算法类型参数:[DecryptionEnm "+decryptionEnm+"]不匹配!");
        }
    }


}
