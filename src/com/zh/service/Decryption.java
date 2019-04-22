package com.zh.service;

import com.zh.medol.*;

import java.util.Queue;

public interface Decryption {

    void calZhangLi(ZhangLiData dataFrame);

    //棘轮角度传感器
    void calRatchetAngle(RatchetAngle dataFrame);

    //坠陀加速度传感器传感器
    void calPendulumAcceleration(PendulumAcceleration dataFrame);

    //舞动算法
    Galloping calGalloping(Queue<Galloping> gallopings);
}
