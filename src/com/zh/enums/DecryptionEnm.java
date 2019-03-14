package com.zh.enums;

import com.zh.common.NotProguard;

@NotProguard
public enum  DecryptionEnm {
    ZHANGLI("1","张力加密算法");
    private String index;
    private String name;

    DecryptionEnm(String index, String name){
        this.index=index;
        this.name=name;
    }
}
