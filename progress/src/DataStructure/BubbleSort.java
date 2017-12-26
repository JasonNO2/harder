package DataStructure;


public class BubbleSort {
    public static void main (String[] args){
        Integer[] integers = {1,5,4,88,9,75,2,33,48,44};
        for (int i = 0; i < integers.length; i++) {
            Integer integer = integers[i];
            System.out.print(integer);System.out.print(",");
        }
        //bubbling
        //外层循环(N个数字要排序)---循环条件：array.length-1
        for (int i = 0; i < integers.length-1; i++) {
            //里层循环(数字要与N个数字比较)---循环条件：array.length-1-i
            //--------如果不减一,在进行换位操作时候会下标越界,假如数组长度为10,当前数字integers[i]与下一个作比较
            //如果i是倒数第一位,那么i=9,i<.length,integers.length=10,
            //还会进行下一次循环,当进行最后一次循环时,i=9,j=10,integers[j]=integers[10]报错
            for (int j = 0; j < integers.length-i-1; j++) {
                if (integers[j] > integers[j+1]) {
                    Integer temp = integers[j];
                    integers[j] = integers[j+1];
                    integers[j+1] = temp;
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < integers.length; i++) {
            Integer integer = integers[i];
            System.out.print(integer);System.out.print(",");
        }
    }
}
