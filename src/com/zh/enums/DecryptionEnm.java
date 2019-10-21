package com.zh.enums;

import com.zh.common.NotProguard;

@NotProguard
public enum  DecryptionEnm {
    ZHANGLI("张力加密算法"),
    RATCHETANGLE("棘轮角度"),
    PENDULUMACCELERATION("坠陀加速度"),
    GALLOPING("舞动加密算法"),
    VIBRATION("振动加密算法"),
    SHUZIZHENDONG("数字振动加密算法");
    private String name;
    DecryptionEnm(String name) {
        this.name=name;
    }
}
