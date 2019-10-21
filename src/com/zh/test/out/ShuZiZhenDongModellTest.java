package com.zh.test.out;

import com.api.out.DecryptionUtil;
import com.api.out.model.ShuZiZhenDongModel;
import com.zh.enums.DecryptionEnm;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuZiZhenDongModellTest {
    static List<ShuZiZhenDongModel> list = new ArrayList<>();

    static {

        File file = new File("D:\\git\\testDemo\\src\\com\\zh\\file\\shuzizhendong.csv");

        if (file.exists() && file.length() > 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = null;
                int i = 0;
                while ((str = bufferedReader.readLine()) != null) {
                    //如果有空格、去掉空格
                    if (str.contains(" ")) {
                        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                        Matcher m = p.matcher(str);
                        str = m.replaceAll("");
                    }
                     System.out.println(str);
                    if (i != 0) {
                        String[] datas = str.split(",");

                        ShuZiZhenDongModel item = new ShuZiZhenDongModel(
                                Double.valueOf(datas[14]),Integer.valueOf(datas[15]),
                                Double.valueOf(datas[17]),Double.valueOf(datas[19]),Double.valueOf(datas[21]),
                                Double.valueOf(datas[18]),Double.valueOf(datas[20]),Double.valueOf(datas[22]),
                                Double.valueOf(datas[13]),Integer.valueOf(datas[16]),
                                Double.valueOf(datas[8]),Double.valueOf(datas[9]),Double.valueOf(datas[10]),"1"
                        );
                        list.add(item);
                    }
                    ++i;
                }
                bufferedReader.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    @Test
    public void calShuZiZhenDong() {

        DecryptionUtil.decryptionCal(list, DecryptionEnm.SHUZIZHENDONG);
        for(ShuZiZhenDongModel item : list){
            System.out.println("xg:"+item.getNewXg()+"      yg:"+item.getNewYg()+"      zg:"+item.getNewZg()+"      振幅："+item.getZhenFu());
        }
    }

}
