package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 20:28 2017/12/25
 * @Modified By:
 */
public class RegExpr {
    /*
    * 如果要从字符串中截取第一个英文左括号之前的字符串,例如：北京市(朝阳区)(西城区)(海淀区),截取结果为:北京市,那么正则表达式如何写？
    * */
    public static void main (String[] args){
        String str="北京市(朝阳区)(西城区)(海淀区)";
        //my(str);
        //reg(str);
        //exp1();
        //exp2();
        exp3();
    }
    static void my(String str){
        int index = str.indexOf("(");
        System.out.println(str.substring(0,index));
    }
    static void reg(String str){
        Pattern pattern = Pattern.compile(".*?(?=\\()");
        Matcher m=pattern.matcher(str);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
    static void exp1(){
        /**
         *@Author:Jason
         *@Description: 将“我我我、、、我我、、我要、我要要、、、要要要、、要要、、学学学、、、、学学编、、、学编编编、、编编编程、、程程”还原成：我要学编程
         *@param
         *@Date:22:25 2017/12/25
         */
        String str = "我我我、、、我我、、我要、我要要、、、要要要、、要要、、学学学、、、、学学编、、、学编编编、、编编编程、、程程";
        str = str.replaceAll("(、+)", "");
        System.out.println(str);
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
    }
    static void exp2(){
        /**
         *@Author:Jason
         *@Description:验证email是否正确
         * * @param
         *@Date:22:34 2017/12/25
         */
        //要验证的字符串
        String str="positiveface@163.com";
        //163邮箱规格
        String reg = "\\w+@163.com";
        //编译正则表达式且忽略大小写
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        //检查字符串是否与正则匹配
        boolean is=matcher.matches();
        System.out.println("163邮箱："+is);
    }
    static void exp3(){
        /**
         *@Author:Jason
         *@Description:在字符串中查找字符或者字符串
         * * @param
         *@Date:22:40 2017/12/25
         */
        String str = ".xsoftlabaikeb.net";
        String reg = ".*baike.*";
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        boolean is=matcher.matches();
        System.out.println("字符串中是否有baike："+is);
    }
}
