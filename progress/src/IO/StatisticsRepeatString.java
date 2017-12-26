package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsRepeatString {

    public static void main (String[] args) throws IOException {
        System.out.println(fun("src/IO/names.txt", "张三"));
    }

    static int fun(String filename,String str) throws IOException {
        /**
         *@Author:Jason
         *@Description:根据文件名,字符串,查找字符串在文件中出现的次数
         *@param filename文件名
         *@param str字符串
         *@Date:15:02 2017/12/22
         */
        int counter=0;
        try (FileReader fileReader = new FileReader(filename); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line=null;
            while ((line = bufferedReader.readLine()) != null) {
                int index=-1;
                while (line.length()>=str.length() && (index=line.indexOf(str))>0) {
                    counter++;
                    line = line.substring(index + str.length());
                }
            }
        }
        return counter;
    }
}
