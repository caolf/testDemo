package com.zh.service;

import com.api.out.model.ShuZiZhenDongModel;
import com.zh.model.*;

import java.util.List;

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

    public static void calGalloping(List<GallopingModel> gallopingModelList){
        decryption.calGalloping(gallopingModelList);
    }

    public static void calVibration(List<VibrationModel> vibrationMedolList){
        decryption.calVibration(vibrationMedolList);
    }

    public static void calGalloping(String sourcePath, String resultPath) {
        decryption.calGalloping(sourcePath,resultPath);
    }

    public static void calShuZiZhenDong(List<ShuZiZhenDongModel> shuZiZhenDongModelList) {
        decryption.calShuZiZhenDong(shuZiZhenDongModelList);
    }

}
