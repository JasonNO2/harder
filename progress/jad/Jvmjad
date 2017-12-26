/*
 * java virtual mechine JVM加载class类问价的原理机制
 * */
public class Jvm {
    public static void main(String[] args) {
        /*
         * JVM是Java虚拟机,也就是在计算机的内存中再虚拟一个计算机
         * JVM只与操作系统打交道,不与硬件打交道
         * JVM可以做到一次编写,随处运行是因为JVM根据不同的CPU翻译了不同的机器语言
         * JVM的组成部分:
         *               ClassFile----->Class Loader(important)
         *                               ||
         * Runtime Data Area            ||
         *    ------------------------------------------------------------------
         *    |       Stack(important)/ Heap(important)/ Method Area(important)|
         *   |      PC Register/ Native Method Stack                          |
         *  |                                                                |
         *  -----------------------------------------------------------------
         *       ||                      ||
         *  Execution Engine--->Native Interface---->Native Libraies
         * */
        //ClassLoader只管加载类(只要符合文件结构)
        //Runtime data area JVM重要的部分，我们所写得程序都被加载在这里
        //Execution Engine(解释器Interpreter)负责解释命令,提交操作系统执行。

        //隐式装载(new生成对象),依照需求加载
        TestModel t = new TestModel() {
            @Override
            public String AnnoInnerClass() {
                return "在JVM类中使用匿名内部类";
            }
        };
        try {
            TestModel t1 = (TestModel) Class.forName("TestModel").newInstance();//显式加载
        } catch (Exception c) {
            c.printStackTrace();
        } finally {
            System.out.println("显式加载");
        }

        //调用类加载器
        /*
         * 输出sun.misc.Launcher$AppClassLoader@18b4aac2
         * */
        ClassLoader cl = TestModel.class.getClassLoader();
        System.out.println(cl);
        //调用上一层类加载器
        /*
         * 输出sun.misc.Launcher$ExtClassLoader@74a14482
         * */
        ClassLoader pcl = cl.getParent();
        System.out.println(pcl);
        //调用根部类加载器
        /*
         * 输出null
         * */
        ClassLoader rcl = pcl.getParent();
        System.out.println(rcl);

        //预先加载,加载系统需要的类

        //自定义类加载器

        //BootstrapLoader<--(Extentds)ExtClassLoader<--(Extends)AppClassLoader

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        //System.out.println(System.getProperty("java.class.path"));


    }
}

