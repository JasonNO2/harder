public class transmit2 {
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
        System.out.println(t2.getP1());
        test(t,t2);
        System.out.println(t.getP1());
        System.out.println(t2.getP1());
    }
    static void test(TestModel t,TestModel t2){
        String str ;
        str=t.getP1();
        t.setP1(t2.getP1());
        t2.setP1(str);
    }
}
