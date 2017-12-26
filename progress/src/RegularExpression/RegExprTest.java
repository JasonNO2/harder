package RegularExpression;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 21:17 2017/12/25
 * @Modified By:
 */
public class RegExprTest {
    public static void main (String[] args){
        String str = "我爱中国 hello hi motherfucker where ;lask,f;lk ggg 快乐池塘";
        // 将所有的字母/空字符/特殊符号去除
        //\p 是property的意思标识Unicode属性,用于Unicode正则表达式的前缀
        //P表示Unicode字符集七个字符属性之一：标点字符
        //其他的：
        //L：字母；
        //M：标记符号（一般不会单独出现）；
        //Z：分隔符（比如空格、换行等）；
        //S：符号（比如数学符号、货币符号等）；
        //N：数字（比如阿拉伯数字、罗马数字等）；
        //C：其他字符
        str = str.replaceAll("\\w|\\s|\\pP", "");
        System.out.println(str);
    }
}
