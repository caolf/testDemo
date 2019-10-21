package com.zh.test.out;
import com.api.out.DecryptionUtil;
import com.api.out.model.ShuZiZhenDongModel;
import com.zh.enums.DecryptionEnm;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SZZ1021 {
    static List<ShuZiZhenDongModel> list = new ArrayList<>();
    private static int oldSize=0;
    private static int NUMBERS=120;
    private static String VERSIONFLAG="2019-10-15";

    @Test
    public void calShuZiZhenDong() {

        List<String> files = Arrays.asList(
                "G:\\CLF\\项目-算法\\20191021振动舞动算法验证\\2019-09-10-old.csv"
        );
        for (String path : files) {
            list = new ArrayList<>();
            read(path);

            DecryptionUtil.decryptionCal(list, DecryptionEnm.SHUZIZHENDONG);

            List<ShuZiZhenDongModel> result=new ArrayList<>();
            for(int i=0;i<list.size();){
                result.addAll(this.cal(i,NUMBERS,list));
                i=i+NUMBERS;
            }
            this.write(path,result);
            list.clear();
        }

    }


    /**
     * 分段计算
     * @param startIndex
     * @param count
     * @param dataSource
     * @return
     */
    private List<ShuZiZhenDongModel> cal(int startIndex,int count,List<ShuZiZhenDongModel> dataSource){
        List<ShuZiZhenDongModel> result=new ArrayList<>();

        if(startIndex+count<dataSource.size()){
            for(int endIndex=startIndex+count;startIndex<endIndex;startIndex++){
                result.add(dataSource.get(startIndex));
            }
        }else {
            for(int endIndex=dataSource.size();startIndex<endIndex;startIndex++){
                result.add(dataSource.get(startIndex));
            }
        }

        DecryptionUtil.decryptionCal(result, DecryptionEnm.SHUZIZHENDONG);
        result.add( new ShuZiZhenDongModel(
                Double.valueOf(0), Integer.valueOf(0),
                Double.valueOf(0), Double.valueOf(0), Double.valueOf(0),
                Double.valueOf(0), Double.valueOf(0), Double.valueOf(0),
                Double.valueOf(0), Integer.valueOf(0),
                Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), this.VERSIONFLAG
        ));
        System.err.println(result.size());
        return result;
    }

    void read(String path){
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
                    System.out.println(str);
                    if (i != 0) {
                        String[] datas = str.split(",");
                        ShuZiZhenDongModel item = new ShuZiZhenDongModel(
                                Double.valueOf(datas[13]), Integer.valueOf(datas[15]),
                                Double.valueOf(datas[17]), Double.valueOf(datas[19]), Double.valueOf(datas[21]),
                                Double.valueOf(datas[18]), Double.valueOf(datas[20]), Double.valueOf(datas[22]),
                                Double.valueOf(datas[14]), Integer.valueOf(datas[16]),
                                Double.valueOf(datas[8]), Double.valueOf(datas[9]), Double.valueOf(datas[10]), "1"
                        );
                        list.add(item);
                    }
                    ++i;
                }
                oldSize = list.size();
                bufferedReader.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    void write(String resultPath, List<ShuZiZhenDongModel> list) {

        if (resultPath == null) {
            throw new RuntimeException("fromPath is error");
        }
        String path = resultPath.substring(0, resultPath.lastIndexOf("\\"));
        String fileName = VERSIONFLAG+"ShuZiZhenDongResult_"+NUMBERS+"_"+resultPath.substring(resultPath.lastIndexOf("\\")+1);
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
            String str = "序号,NewX,NewY,NewZ,NewXg,NewYg,NewZg,pinLv(频率),zhenFu（振幅）";
            bufferedWriter.append(str);
            bufferedWriter.newLine();
            List<? extends Number> rows = new ArrayList<>();
            int index=0;
            for (int i = 0, length = list.size(); i < length; i++) {
                ShuZiZhenDongModel item = list.get(i);
                if(VERSIONFLAG.equals(item.getVersion())){
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }else {
                    str = Arrays.asList(index, item.getNewX(), item.getNewY(), item.getNewZ(),
                            item.getNewXg(), item.getNewYg(), item.getNewZg(),
                            item.getPinLv(),item.getZhenFu()).toString();
                    str = str.substring(1,str.length()-1);
                    bufferedWriter.append(str);
                    index++;
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
