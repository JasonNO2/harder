package DataStructure;

public class SelectSort {
    public static void main (String[] args){
        Integer[] integers = {1,5,4,88,9,75,2,33,48,44};
        for (int i = 0; i < integers.length-1; i++) {
            for (int j = i+1; j < integers.length; j++) {
                if(integers[i] > integers[j]) {
                    Integer temp = integers[i];
                    integers[i]=integers[j];
                    integers[j]=temp;
                }
            }
        }
        for (int i = 0; i < integers.length; i++) {
            Integer integer = integers[i];
            System.out.print("  "+integer);
        }
    }
}
