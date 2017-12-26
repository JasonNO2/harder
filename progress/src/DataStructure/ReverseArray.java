package DataStructure;

import java.io.UnsupportedEncodingException;

public class ReverseArray {
    public static void main (String[] args) throws UnsupportedEncodingException {
        int[] a=new int[]{20,40,88,74,2,5,15,8,13};
//        //将其倒序
//        Integer[] ra = new Integer[]{};
//        List<Integer> pl = new ArrayList<>();
//        for (int i = a.length-1; i >=0; i--) {
//            int i1 = a[i];
//            pl.add(i1);
//        }
//        ra=pl.toArray(ra);
//        for (int i = 0; i < ra.length; i++) {
//            int i1 = ra[i];
//            System.out.println(i1);
//        }
        //简单方法
        reverse(a);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
        //字符串的反序排列
        String str="abdajgrenkjtlidjgl,sgjsfdsj";
        byte[] bytes = str.getBytes("utf-8");
        reverseBytes(bytes);
        String reverseStr = new String(bytes, "utf-8");
        System.out.println(reverseStr);
        String str2="你好中国";
        byte[] bytes2 = str2.getBytes("GBK");
        reverseBytes(bytes2);
        String reverseStr2 = new String(bytes2, "GBK");
        System.out.println(reverseStr2);
    }
    static void reverse(int[] a){
        int len=a.length;
        //0 8 7---->20 8
        //1 8 6---->40 15
        //条件等同于for(int i=0,int j=a.length-1;i<j;i++,j--)
        for (int i = 0; i < len / 2; i++) {
            int t = a[i];
            a[i]=a[len-i-1];
            a[len-i-1]=t;
        }
    }
    static void reverseBytes(byte[] a){
        int len=a.length;
        //0 8 7---->20 8
        //1 8 6---->40 15
        //条件等同于for(int i=0,int j=a.length-1;i<j;i++,j--)
        for (int i = 0; i < len / 2; i++) {
            byte t = a[i];
            if (t < 0) {
                //错位交换
                byte t2 = a[i + 1];
                a[i]=a[len-i-2];
                a[i+1]=a[len-i-1];
                a[len-i-2]=t;
                a[len-i-1]=t2;
                ++i;
            } else {
                a[i]=a[len-i-1];
                a[len-i-1]=t;
            }
        }
    }
}
