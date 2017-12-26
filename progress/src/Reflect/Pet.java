package Reflect;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 9:55 2017/12/26
 * @Modified By:
 */
public class Pet {
    public String name;

    public void print(){
        System.out.println("method print of Pet");
    }
    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
