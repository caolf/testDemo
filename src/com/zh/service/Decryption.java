package com.zh.service;

import com.api.out.model.ShuZiZhenDongModel;
import com.zh.model.*;

import java.util.List;

public interface Decryption {

    void calZhangLi(ZhangLiData dataFrame);

    //棘轮角度传感器
    void calRatchetAngle(RatchetAngle dataFrame);

    //坠陀加速度传感器传感器
    void calPendulumAcceleration(PendulumAcceleration dataFrame);

    //舞动算法
    void calGalloping(String sourcePath,String resultPath);

    void calGalloping(List<GallopingModel> vibrationMedolList);

    //振动加密算法
    void calVibration(List<VibrationModel> vibrationMedolList);

    void calShuZiZhenDong(List<ShuZiZhenDongModel> shuZiZhenDongModelLists);

}
