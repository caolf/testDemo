package com.zh.common;

import java.math.BigDecimal;

public class DataUtil {

    public static final int FOMATE_FOUR = 4;

    public static Double dataFomateByParam(Double data,int fomate){
        Double result=null;
        BigDecimal bigDecimal=new BigDecimal(data);
        result=bigDecimal.setScale(fomate,BigDecimal.ROUND_UP).doubleValue();
        return result;
    }
}
