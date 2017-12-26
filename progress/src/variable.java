import java.util.ArrayList;
import java.util.List;

public class variable {

    public static void main(String[] args) {
        float a = (float) 3.4;
        float b = 3.4F;
        double c = 3.4;
        short d = 1;
        //下面的代码出错
        //d=d+1;
        d = (short) (d + 1);
        //d+=1等价于d=(short)(d+1)
        d += 1;

        Integer e = new Integer(5);
        Integer f = 5;    //常量5自动装箱为Integer对象
        int g = 5;
        System.out.println(e == f);    //false e和f引用不同的对象
        System.out.println(e == g);    //true e自动拆箱，之后与5进行比较所以为true

        Integer h1 = 100, h2 = 100, h3 = 150, h4 = 150;
        System.out.println(h1 == h2);        //true 常量值在-128-127之间的话Integer不再创建新对象，而是直接引用常量池中的对象,所以h1==h2 等于true
        System.out.println(h3 == h4);        //false h3 h4不再常量池中,所以Integer自动装箱为不同对象
        //int Integer自动拆装箱操作
        //给Integer赋值int时Integer使用valueOf方法返回Integer对象

		/*intern 方法将字符串常量动态的添加到常量池中,
        intern方法将会查找常量池中是否已经存在字符串,如何存在直接返回引用
		如何不存在,将常量放入,之后返回此引用*/
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);//true
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);//false

        //Math.round 方法,四舍五入,底部原理是值+0.5,向下取整
        Math.round(11.5);//12
        Math.round(-11.5);//11

		/*
		数组在两种情况下是java中效率最高的数据结构
			1:知道查询位置
			2:数据量小
		 */
        List<Integer> array = new ArrayList<Integer>();
        System.out.println(array.size());
        String array2 = "     ";
        System.out.println(array2.length());

        TestModel o1 = new TestModel(){
            @Override
            public String AnnoInnerClass(){
                return "在variable中使用匿名内部类";
            }
        };
        TestModel o2 = o1;
        System.out.println(o1 == o2);
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());

        /*
         * java中只支持参数的值传递。当一个实例对象作为参数被传递到方法中,参数的值就是对改对象的引用。
         * 对象的属性可以在方法中被改变,但是引用对象改变是不会影响到调用者的
         * */
        //对象引用作为参数传递问题
        o1.setP1("hello");
        o2.setP2(" world");
        //对象引用的值
        System.out.println(o1.getP1());
        System.out.println(o1.getP2());
        System.out.println(o1.hashCode());
        print(o1);

        //修改对象引用参数值之后
        System.out.println(o1.getP1());
        System.out.println(o1.getP2());
        System.out.println(o1.hashCode());

        //不会改变
        int k = 5, l = 10;
        print2(k, l);
        System.out.println(k);
        System.out.println(l);
    }

    static void print(TestModel t) {
        //修改之前
        System.out.println(t.getP1());
        System.out.println(t.getP2());
        //修改值
        t.setP1("你好");
        t.setP2("世界");
        t = new TestModel(){
            @Override
            public String AnnoInnerClass(){
                return "在variable的print方法中使用匿名内部类";
            }
        };;
    }

    static void print2(int a, int b) {
        //修改之前
        System.out.println(a);
        System.out.println(b);
        //修改
        int temp = a;
        a = b;
        b = temp;
    }
}
