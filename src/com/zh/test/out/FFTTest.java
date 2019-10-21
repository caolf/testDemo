package com.zh.test.out;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import org.junit.Test;

/**
 * @Author  傅里叶转换测试
 * @Date 2019/9/8
 * @Desc
 */
public class FFTTest {

   private static final int size = 10;



   @Test
    public void test(){
        double[] inputData = new double[size];
        for (int i=0;i<size;i++){
            inputData[i] = i * 5;
        }

        FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
        Complex[] result = fft.transform(inputData, TransformType.FORWARD);

        for (Complex item : result){
            System.out.println("getReal  "+item.getReal() + "getImaginary   "+item.getImaginary());
        }

    }
}
