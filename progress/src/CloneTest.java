public class CloneTest {
    public static void main (String[] args) throws Exception {
        TestModel t = new TestModel() {
            @Override
            public String AnnoInnerClass() {
                return "在CloneTest里使用匿名内部类";
            }
        };
        t.setP1("hello");
        t.setP2("world");

        //深度克隆
        TestModel t2=Clone.clone(t);
        System.out.println(t2.getP1()+"-"+t2.getP2());
        t.setP2("hi");
        t.setP1("world");
        System.out.println(t2.getP1()+"-"+t2.getP2());
    }
}
