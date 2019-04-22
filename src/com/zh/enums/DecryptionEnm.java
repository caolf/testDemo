package com.zh.enums;

import com.zh.common.NotProguard;

@NotProguard
public enum  DecryptionEnm {
    ZHANGLI("张力加密算法"), RATCHETANGLE("棘轮角度"), PENDULUMACCELERATION("坠陀加速度");
    private String name;
    DecryptionEnm(String name) {
        this.name=name;
    }
}
