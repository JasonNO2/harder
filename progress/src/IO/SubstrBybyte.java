package IO;

import java.io.UnsupportedEncodingException;

public class SubstrBybyte {
    public static void main (String[] args) throws UnsupportedEncodingException {
        String str = "我爱China中国,你爱China中国嘛?";
        byte[] bytes=str.getBytes("GBK");

        for (int i = 0; i < bytes.length; i++) {
            byte aByte = bytes[i];
            System.out.print(aByte);
            System.out.print(",");
        }

        System.out.println(str.substring(0,getByBytes(bytes,10)));
    }
    /*
    * 根据截取的字节长度,获取字符串
    * GBK的汉子字节是两个
    * 汉子字节都是负数
    * */
    static int getByBytes(byte[] bytes, int n) {
        boolean flag=false;
        int num=0;
        for (int i = 0; i < n; i++) {
            if (bytes[i] < 0 && !flag) {
                flag = true;
            } else {
                num++;
                flag = false;
            }
        }
        return num;
    }
}
