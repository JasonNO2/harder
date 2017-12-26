import java.io.UnsupportedEncodingException;

public class StringStatistics {
    public static void main (String[] args) throws UnsupportedEncodingException {
        String str="hello$@^^%$&哎呀妈呀我的天666777888@！#%￥%……&……%￥";
        String str2 = "1121";
        String str3 = "￥￥￥￥！！";
        //统计字符串中中文字符数英文字符数数字数字符数
        byte[] bytes = str.getBytes("GBK");
        byte[] bytes2 = str2.getBytes("GBK");
        byte[] bytes3 = str3.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            byte aByte = bytes[i];
            System.out.print(aByte);
            System.out.print(",");
        }
        System.out.println("");
        for (int i = 0; i < bytes2.length; i++) {
            byte aByte = bytes2[i];
            System.out.print(aByte);
            System.out.print(",");
        }
        System.out.println("");
        for (int i = 0; i < bytes3.length; i++) {
            byte aByte = bytes3[i];
            System.out.print(aByte);
            System.out.print(",");
        }
        int numcount=0,engcount=0,chinesecount=0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                numcount++;
            } else if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                engcount++;
            } else {
                chinesecount++;
            }
        }
        System.out.println("数字："+numcount+"个，英文字符："+engcount+",汉字字符:"+chinesecount);
    }
}
