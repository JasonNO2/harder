package Reflect;

/**
 * @Author:Jason
 * @Description:获取类的三种方法
 * @Date:Created in 8:38 2017/12/26
 * @Modified By:
 */
public class AcquireClass {
    public static void main (String[] args) throws Exception{
        Class clazz=String.class;
        Class clazz2="hello".getClass();
        Class clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz);
        System.out.println(clazz2);
        System.out.println(clazz3);
        //通过反射创建对象的方法
        //①通过类对象调用newInstance方法
        String str=String.class.newInstance();
        //②通过类对象的getDeclaredConstructor方法获取类对象的构造方法,接着使用newInstance获取对象
        String str2 = String.class.getDeclaredConstructor(String.class).newInstance("hello");
        System.out.println(str2);


    }
}
