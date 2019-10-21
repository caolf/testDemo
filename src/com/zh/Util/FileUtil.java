package com.zh.Util;

import com.zh.model.SourceGalloping;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtil {

    public static void read(String sourcePath, List<SourceGalloping> sourceDatas, int startIndex) {

        if (sourcePath == null) {
            throw new RuntimeException("fromPath is error");
        }
        File file = new File(sourcePath);

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
                    if (i > startIndex) {
                        String[] datas = str.split(",");
                        SourceGalloping sourceGalloping = new SourceGalloping();
                        sourceGalloping.setTime(datas[0] + "," + datas[1] + "," + datas[2] + "," + datas[3] + "," + datas[4] + "," + datas[5]);
                        sourceGalloping.setX(Double.valueOf(datas[8]));
                        sourceGalloping.setY(Double.valueOf(datas[9]));
                        sourceGalloping.setZ(Double.valueOf(datas[10]));
                        sourceGalloping.setX1(Double.valueOf(datas[17]));
                        sourceGalloping.setY1(Double.valueOf(datas[19]));
                        sourceGalloping.setZ1(Double.valueOf(datas[21]));
                        sourceDatas.add(sourceGalloping);
                    }
                    ++i;
                }
                bufferedReader.close();
                fileInputStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void write(String resultPath, List<SourceGalloping> sourceGallopings) {

        if (resultPath == null) {
            throw new RuntimeException("fromPath is error");
        }
        String path = resultPath.substring(0, resultPath.lastIndexOf("\\"));
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(path, "result.csv");
            if (!file.exists() && !file.createNewFile()) {
                throw new RuntimeException("new File error!");
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "GB2312"));
            String str = "年,月,日,时,分,秒,索引点,X,Y,Z";
            bufferedWriter.append(str);
            bufferedWriter.newLine();
            for (int i = 0, length = sourceGallopings.size(); i < length; i++) {
                str = sourceGallopings.get(i).getTime() + "," + i + "," + sourceGallopings.get(i).toString();
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
