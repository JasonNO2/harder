package DataStructure;

public class RecursionArithmetic2 {
    public static void main (String[] args){
        System.out.println(agePlusTwo(8));
    }
    static int agePlusTwo(int n){
        if (n == 1) {
            return 10;
        }
        return agePlusTwo((n-1)+2);
    }
}
