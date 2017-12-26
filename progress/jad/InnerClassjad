import java.util.StringTokenizer;

public class InnerClass {
    //成员
    private String v;
    public int v2;
    public static int v3;
    //内部类,内部类加上static关键字成为static nested class(静态嵌套类),访问修饰符可以是public protected default private,
    public static class inner1{
        public void method(){
            System.out.println("inner1 method"+v3);
        }
    }

    public void method(){
        //方法体中的内部类,不能有访问修饰符
        class inner2{
            public void method(){
                System.out.println("inner2 method"+v);
            }
        }
        inner2 inner2=new inner2();
        inner1 inner1=new inner1();
        inner2.method();
        inner1.method();
    }
    public static void main (String[] args){
        InnerClass innerClass=new InnerClass();
        innerClass.method();
        //使用内部类的外部类创建内部类对象
        //当内部类使用static修饰时,使用InnerClass.inner1()创建实例
        InnerClass.inner1 inner1=new InnerClass.inner1();
        //InnerClass.inner1 inner1=innerClass.new inner1();
        //inner1.method();

        //StringTokenizer
        StringTokenizer stringTokenizer=new StringTokenizer("a,b,c,d",",");
        while (stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextElement());
        }

        /*
        *构造器的调用顺序：
        * 初始化静态成员-->调用父类构造器-->初始化非静态成员-->调用自身构造器
        * */
        A ab=new B();
        ab=new B();
    }
}
//.java源文件中只能有一个公开类(public class)
class class2{};
class A{
    static {
        System.out.println(1);
    }

    public A() {
        System.out.println("A");
    }
}

class B extends A{
    static{
        System.out.println(2);
    }

    public B() {
        System.out.println("B");
    }
}