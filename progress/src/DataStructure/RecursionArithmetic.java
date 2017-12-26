package DataStructure;

public class RecursionArithmetic {
    public static void main (String[] args){
        increce2N(1237);
    }
    static void increce2N(int a){
        System.out.println(a);
        if (a < 5000) {
            increce2N(a*2);
        }
        System.out.println(a);
    }
}
