package com.zh.common;

import java.math.BigDecimal;

public class DataUtil {

    public static Double dataFomateByParam(Double data,int param){
        Double result=null;
        BigDecimal bigDecimal=new BigDecimal(data);
        result=bigDecimal.setScale(param,BigDecimal.ROUND_UP).doubleValue();
        return result;
    }
}
