package Constructor;

public class Child  extends Father{
    private String name;
    private int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Child() {
        super("jason",10);
        System.out.println("儿子的构造器");
    }
}
