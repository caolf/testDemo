package com.zha;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import java.util.ArrayList;
import java.util.List;

public class ZhenDongService {

    private List a_xyz = new ArrayList();
    private Double Ts = 0.1; //读取源文件中TS列的数据
    private Integer N = 10 + 1; //读取源文件中n列的数据，并计算n+1
    private Integer dN = (N - 1) / 2 + 1; //用到一个中间变量dN,
    //（1）计算加计均值
    private Array2DRowRealMatrix a_xyz_N = new Array2DRowRealMatrix(N, 3);
    private Array2DRowRealMatrix p_xyz_N = new Array2DRowRealMatrix(N, 3);
    private Array2DRowRealMatrix a = new Array2DRowRealMatrix(3, 1);
    private Array2DRowRealMatrix v = new Array2DRowRealMatrix(3, 1);
    private Array2DRowRealMatrix p = new Array2DRowRealMatrix(3, 1);
    private Array2DRowRealMatrix p_out = new Array2DRowRealMatrix(3, 1);
    private Integer n_save = 0;
    private Array2DRowRealMatrix avp = new Array2DRowRealMatrix(a_xyz.size(), 9);


    // 震动参数初始化
    private Array2DRowRealMatrix p_out_ = new Array2DRowRealMatrix(3,1) ;
    private Integer pmin_x = 0 ;
    private Integer pmin_y = 0 ;
    private Integer pmin_z = 0 ;
    private Integer pmax_x = 0 ;
    private Integer pmax_y = 0 ;
    private Integer pmax_z = 0 ;
    private Array2DRowRealMatrix pmaxmin_x_m = new Array2DRowRealMatrix(1,3) ;
    private Array2DRowRealMatrix pmaxmin_y_m = new Array2DRowRealMatrix(1,3)  ;
    private Array2DRowRealMatrix pmaxmin_z = new Array2DRowRealMatrix(1,3)  ;


    public  void cal(){
        
    }

}
