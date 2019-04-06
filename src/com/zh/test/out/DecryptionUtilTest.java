package com.zh.test.out;

import com.zh.enums.DecryptionEnm;
import com.zh.medol.ZhangLiData;
import com.zh.out.DecryptionUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecryptionUtilTest {
    static List<ZhangLiData> old = new ArrayList<>();
    static List<ZhangLiData> news = new ArrayList<>();

    static {

        File file = new File("D:\\git\\testDemo\\src\\com\\zh\\test\\out\\zhanlishuju.csv");

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
                    // System.out.println(str);
                    if (i != 0) {
                        String[] datas = str.split(",");
                        ZhangLiData zhangLiDataOld = new ZhangLiData();
                        zhangLiDataOld.setTime(datas[0] + datas[1] + datas[2] + datas[3] + datas[4] + datas[5]);
                        zhangLiDataOld.setOldData(Double.valueOf(datas[6]));
                        old.add(zhangLiDataOld);

                        ZhangLiData zhangLiDataNew = new ZhangLiData();
                        zhangLiDataNew.setTime(datas[10] + datas[11] + datas[12] + datas[13] + datas[14] + datas[15]);
                        zhangLiDataNew.setNewData(Double.valueOf(datas[16]));
                        news.add(zhangLiDataNew);
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
    public void calZhangLi() {
        ZhangLiData data = new ZhangLiData();
        data.setTime("2018,10,31,13,2,13,");
        data.setOldData(0.744629);
        DecryptionUtil.decryptionCal(DecryptionEnm.ZHANGLI,data);
        System.out.println(data.getNewData());
        Assert.assertEquals(new Double(6.633967455),data.getNewData());

        int num = 0;
        for (int i = 0, len = old.size(); i < len; i++) {
            DecryptionUtil.decryptionCal(DecryptionEnm.ZHANGLI, old.get(i));

            if (old.get(i).getNewData().doubleValue() != news.get(i).getNewData().doubleValue()) {
                System.out.println("error:" + old.get(i).getTime() + "      计算值:" +
                        old.get(i).getNewData() + "      实验值：" + news.get(i).getNewData()
                        + "      误差：" + (old.get(i).getNewData() - news.get(i).getNewData()));

                num++;
            }

            //Assert.assertEquals(old.get(i).getNewData(),news.get(i).getNewData());
        }
        System.out.println("总数:" + old.size() + "   错误数据：" + num);
    }
}
