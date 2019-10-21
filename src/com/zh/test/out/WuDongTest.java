package com.zh.test.out;

import com.api.out.DecryptionUtil;
import com.zh.enums.DecryptionEnm;
import com.zh.model.GallopingModel;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WuDongTest {
    static List<GallopingModel> list = new ArrayList<>();

//    static {
//
//        File file = new File("D:\\git\\testDemo\\src\\com\\zh\\file\\shuzizhendong.csv");
//
//        if (file.exists() && file.length() > 0) {
//            try {
//                FileInputStream fileInputStream = new FileInputStream(file);
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
//                String str = null;
//                int i = 0;
//                while ((str = bufferedReader.readLine()) != null) {
//                    //如果有空格、去掉空格
//                    if (str.contains(" ")) {
//                        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//                        Matcher m = p.matcher(str);
//                        str = m.replaceAll("");
//                    }
//                    System.out.println(str);
//                    if (i != 0) {
//                        String[] datas = str.split(",");
//                        /*public GallopingModel(
//                                    String time,
//                        double x, double y, double z,
//                        double ts, int nMax,
//                        double x0, double y0, double z0,
//                        double x1, double y1, double z1,
//                        double b, int nMin) */
//                        GallopingModel item = new GallopingModel(
//                                datas[0] + datas[1],
//                                Double.valueOf(datas[8]), Double.valueOf(datas[9]), Double.valueOf(datas[10]),
//                                Double.valueOf(datas[14]), Integer.valueOf(datas[15]),
//                                Double.valueOf(datas[17]), Double.valueOf(datas[19]), Double.valueOf(datas[21]),
//                                Double.valueOf(datas[18]), Double.valueOf(datas[20]), Double.valueOf(datas[22]),
//                                Double.valueOf(datas[13]), Integer.valueOf(datas[16])
//                        );
//                        list.add(item);
//                    }
//                    ++i;
//                }
//                bufferedReader.close();
//                fileInputStream.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//


    @Test
    public void calWudDongTest() {

        List<String> files = Arrays.asList(
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\9日\\2019-09-09-15-01-chenglisuokuazhongzhendong.csv",
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\9日\\2019-09-09-869029035242212-fujiadaoxianzhendong.csv",
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\9日\\2019-09-09-869029035261774-fujiadaoxianweifengzhendong.csv",
                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\9日\\2019-09-09-869029035365146-xuanguadianzhendongwendu.csv",
                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\9日\\2019-09-09-869029035378347-dingweiqizhendong.csv"
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\10日\\2019-09-10-15-01-chenglisuokuazhongzhendong.csv",
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\10日\\2019-09-10-869029035242212-fujiadaoxianzhendong.csv",
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\10日\\2019-09-10-869029035261774-fujiadaoxianweifengzhendong.csv",
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\10日\\2019-09-10-869029035365146-xuanguadianzhendongwendu.csv"
//                "C:\\Users\\GXZ\\Desktop\\20190920结果验证\\10日\\2019-09-10-869029035378347-dingweiqizhendong.csv"
        );
        for (String path : files) {
            List<GallopingModel> datas = read(path);

            DecryptionUtil.decryptionCal(datas, DecryptionEnm.GALLOPING);
            write(path, datas);
//            int i=0;
////            for (GallopingModel item : datas) {
////                System.out.println("序号：" + i + "       x:" + item.getNewX() + "      y:" + item.getNewY() + "      z:" + item.getNewZ() );
////                System.out.println("序号：" + i + "       xg:" + item.getNewXg() + "      yg:" + item.getNewYg() + "      zg:" + item.getNewZg() );
////                i++;
////            }
        }


    }

    List<GallopingModel> read(String path){
        List<GallopingModel> gallopingModelList = new ArrayList<>();
        File file = new File(path);

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
//                    System.out.println(str);
                    if (i != 0) {
                        if (i > 8458 && i < 8521) {
                           System.out.println(str);
                        }
                        String[] datas = str.split(",");
                        /*public GallopingModel(
                                    String time,
                        double x, double y, double z,
                        double ts, int nMax,
                        double x0, double y0, double z0,
                        double x1, double y1, double z1,
                        double b, int nMin) */
                        GallopingModel item = new GallopingModel(
                                datas[0] + datas[1],
                                Double.valueOf(datas[8]), Double.valueOf(datas[9]), Double.valueOf(datas[10]),
                                Double.valueOf(datas[14]), Integer.valueOf(datas[15]),
                                Double.valueOf(datas[17]), Double.valueOf(datas[19]), Double.valueOf(datas[21]),
                                Double.valueOf(datas[18]), Double.valueOf(datas[20]), Double.valueOf(datas[22]),
                                Double.valueOf(datas[13]), Integer.valueOf(datas[16])
                        );
                        gallopingModelList.add(item);
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
        return gallopingModelList;
    }
    void write(String resultPath, List<GallopingModel> list) {

        if (resultPath == null) {
            throw new RuntimeException("fromPath is error");
        }
        String path = resultPath.substring(0, resultPath.lastIndexOf("\\"));
        String fileName = "WudongResult_" + resultPath.substring(resultPath.lastIndexOf("\\") + 1);
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(path, fileName);
            if (!file.exists() && !file.createNewFile()) {
                throw new RuntimeException("new File error!");
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "GB2312"));
            String str = "序号,NewX,NewY,NewZ,NewXg,NewYg,NewZg";
            bufferedWriter.append(str);
            bufferedWriter.newLine();
            List<? extends Number> rows = new ArrayList<>();
            for (int i = 0, length = list.size(); i < length; i++) {
                GallopingModel item = list.get(i);
                str = Arrays.asList(i, item.getNewX(), item.getNewY(), item.getNewZ(),
                        item.getNewXg(), item.getNewYg(), item.getNewZg()).toString();
                str = str.substring(1, str.length() - 1);
                bufferedWriter.append(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
