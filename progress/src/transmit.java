public class transmit{

    //ja底是值传递还是引用传递

    public static void main (String[] args){
        TestModel t=new TestModel("hi","there") {
            @Override
            public String AnnoInnerClass() {
                return "hello";
            }
        };
        TestModel t2=new TestModel("hey","you") {
            @Override
            public String AnnoInnerClass() {
                return "yeah";
            }
        };
        System.out.println(t.getP1());
        System.out.println(t.getP2());
        System.out.println(t2.getP1());
        System.out.println(t2.getP2());
        System.out.println("----------------------");
        test(t,t2);
        System.out.println(t.getP1());
        System.out.println(t.getP2());
        System.out.println(t2.getP1());
        System.out.println(t2.getP2());

    }
    static void test(TestModel t,TestModel t2) {
        //t t2是main中传过来的对象的副本
        //这里改变了引用,但是在外部没有影响,所以不是传引用,而是传引用对象指向的值
        TestModel temp;
        temp=t;
        t=t2;
        t2=temp;
    }
}
