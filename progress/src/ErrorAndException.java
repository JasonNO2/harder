import java.sql.SQLException;

public class ErrorAndException{
    public static void main (String[] args){
        //运行下面的代码将会导致Error stack over flow
        //Error表示系统级错误和程序不必处理的异常,指恢复不是不可能但比较困难,不能指望程序去解决它
        //main(null);

        //Exception表示需要捕捉或者程序处理的异常,是一种设计或实现问题;也就是说,他表示程序如果正常运行,从不会发生的情况
        //下面的代码将会出现NullPointerException
        //TestModel t=null;
        //System.out.println(t.getP2());

        /*
        * try中的return并不会立马返回调用者,而是记录返回值,等待finally代码块执行
        * 完毕之后在向调用者返回其值,所以在finally中修改返回值是错误的行为
        * */
        try {
            TestModel t=null;
            System.out.println(t.getP2());
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("NullPointerException");
        }
        //try-catch-throw-throws-finally

        try {
            throw new SQLException();
        } catch (SQLException s) {
            s.printStackTrace();
        }finally {
            System.out.println("SQLException");
        }

        try {
            throw new CustomerException2("出错啦！笨蛋！");
        } catch (CustomerException c) {
            System.out.println("CustomerException");
            c.printStackTrace();
        }finally {
            System.out.println("Exception");
        }

        /*
        * 异常处理机制,java的异常(Error和Exception)分为可查异常(checked Exception)和不可查异常(unchecked Exception)
        * 可查异常是编译器强制要求必须处理的异常,
        * 除了RuntimeException及其子类外,其他的Exception及其子类都是可查异常。
        * 不可查异常是编译器不强制要求处理的异常,
        * 包括RuntimeException和Error。
        * Exception这种异常分为运行时异常和非运行时异常
        * 运行时异常：IndexOutOfBoundsException.ArithmeticException.NullPointerException.不可查异常,程序中可以处理
        * 也可以不处理,这些异常一般是程序设计及实现问题,应尽可能避免这些异常
        * 非运行时异常：不进行处理编译器不能编译通过
        * */


        try {//不可查异常 运行时异常 非强制处理
            TestModel t=null;
            System.out.println(t.getP2());
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("NullPointerException");
        }

        Stream s=new Stream();
        try {//可查异常 非运行时异常 强制处理
            s.dosomething();
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }
}

