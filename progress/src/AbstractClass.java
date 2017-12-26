/*
 * 抽象类可以实现接口
 * 可以继承类具体类
 * 可以有静态的main方法
 * 可以有非抽象方法
 * 但是如果有抽象方法
 * 类必须为抽象类
 * 抽象类除了可以有抽象方法之外其他的和具体类一样
 * */
public abstract class AbstractClass extends TestModel implements Interface {
    static void main(String[] args) {
        //在接口上使用匿名内部类
        Interface in = new Interface() {
            @Override
            public void fun1() {
                System.out.println("hello");
            }
        };
    }

    //抽象类中可以有非抽象方法
    public void fun1() {

    }

    public void fun2() {

    }

    public void fun3() {

    }

    //抽象方法
    abstract void fun4();
}
