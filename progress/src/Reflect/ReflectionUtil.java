package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 8:50 2017/12/26
 * @Modified By:
 */
public class ReflectionUtil {


    private ReflectionUtil() {
    }
    public static void main (String[] args){
        TestModel2 testModel2=new TestModel2();
        testModel2.setName("JASON");
        testModel2.setAge(20);
        //Pet pet = new Pet("哈士奇");
        //testModel2.setPet(pet);
        setValue(testModel2, "pet.name", "柯基");
        System.out.println(testModel2.getPet().name);
        String petname=(String) getValue(testModel2, "pet.name");
        System.out.println(petname);
        callMethod(testModel2, "print");
        callMethod2(testModel2, "print");
        callMethod2(testModel2, "pet.print");
    }
    public static Object getValue(Object target,String fieldName){
        /**
         *@Author:Jason
         *@Method:
         *@Description:
         * @param target
         * @param fieldName
         *@Returns:java.lang.Object
         *@Date:8:59 2017/12/26
         */
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        try {
            for(int i = 0; i < fs.length - 1; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            return f.get(target);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void setValue(Object target,String fieldName,Object value){
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        try {
            for(int i = 0; i < fs.length - 1; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                //如果属性为空,获取构造器,创建对象并赋值
                if(val == null) {
                    Constructor<?> c = f.getType().getDeclaredConstructor();
                    c.setAccessible(true);
                    val = c.newInstance();
                    f.set(target, val);
                }
                target = val;
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            f.set(target, value);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //根据方法名调用方法
    public static void callMethod(Object target,String m){
        Class<?> clazz=target.getClass();
        try {
            Method method = clazz.getMethod(m);
            method.invoke(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //多级调用
    public static void callMethod2(Object target,String m){
        Class<?> clazz=target.getClass();
        String[] ms=m.split("\\.");
        try {
            for (int i = 0; i < ms.length-1; i++) {
                Field f = clazz.getDeclaredField(ms[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                if (val == null) {
                    Constructor<?> c = f.getType().getDeclaredConstructor();
                    val = c.newInstance();
                    f.set(target, val);
                }
                //此时要操作的目标对象应当是根据属性名获取到的对象
                target=val;
                //获取目标对象的类对象
                clazz=target.getClass();
            }
            Method method=clazz.getMethod(ms[ms.length-1]);
            method.invoke(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
