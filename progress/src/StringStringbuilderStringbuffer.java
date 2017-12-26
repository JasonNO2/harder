public class StringStringbuilderStringbuffer {
    /*
     * Stirng
     * StringBuilder
     * StringBuffer
     * 三者的区别
     * */
    public static void main(String[] args) {
        //String是final类不能被继承,引用的字符串内容不能更改,只读
        String s1 = "hello";
        String s2 = "java";
        System.out.println(s1 == s2);//false
        //StringBuilder是非线程安全的,所以效率也更高,引用的字符串内容可以直接更改
        StringBuilder stringBuilder = new StringBuilder("sb");
        stringBuilder.append(10);
        //StringBuffer是线程安全的,
        StringBuffer sbf = new StringBuffer("sbf");
        sbf.append(10);

        /*
         * 输出下面的值
         * */
        String a = "programming";
        String b = new String("programming");
        String c = "program";
        String d = "ming";
        String e = "program" + "ming";
        String f = c + d;
        System.out.println(a == b);//false
        System.out.println(a == e);//true
        System.out.println(a == f);//false
        System.out.println(a == f.intern());//true
        System.out.println(a == b.intern());//true
        System.out.println(f == b.intern());//false
        System.out.println(e == b.intern());//true
        /*intern 方法将字符串常量动态的添加到常量池中,
        intern方法将会查找常量池中是否已经存在字符串,如何存在直接返回引用
		如何不存在,将常量放入,之后返回此引用*/


        //下面的语句一共创建了多少个对象,在编译器中编译后相当于String g="abcd";
        String g = "a" + "b" + "c" + "d";

        //自定义反转字符串方法
        System.out.println(reverse("Jason is handsome"));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        } else {
            return reverse(originStr.substring(1))+ originStr.charAt(0);
        }
    }
}
