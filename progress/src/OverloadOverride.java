public class OverloadOverride {
    //方法重载
    static int test(int a) {
        return a;
    }

    static String test(String a) {
        return a;
    }

    static boolean test(boolean a) {
        return a;
    }

    String test2() {
        return "fuck you";
    }

    public static void main(String[] args) {
        System.out.println(test(0));
        System.out.println(test("hello"));
        System.out.println(test(false));
    }
}
