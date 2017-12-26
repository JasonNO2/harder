package Reflect;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 9:40 2017/12/26
 * @Modified By:
 */
public class TestModel2 {
    private String name;
    private int age;
    private Pet pet;
    public void print(){
        System.out.println("method print of TestModel2");
    }
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public TestModel2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestModel2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
