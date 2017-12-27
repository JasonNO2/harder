package DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:27 2017/12/27
 * @Modified By:
 */
public class BubbleSorter  implements BubbleSortSuperior{
    public static void main (String[] args){
        BubbleSorter bubbleSorter=new BubbleSorter();
        String[] list1 = {"12","14","64","44","5548","47","88"};
        String[] list2 = {"111","444","666","999","333","222","777"};

        System.out.println("遍历list2----------------------------");
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            System.out.print(s+",");
        }
        System.out.println("");
        System.out.println("遍历list1----------------------------");
        for (int i = 0; i < list1.length; i++) {
            String s = list1[i];
            System.out.print(s+",");
        }
        System.out.println("");
        System.out.println("排序后的list2------------------------");
        bubbleSorter.sort(list2);
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            System.out.print(s+",");
        }
        System.out.println("");
        System.out.println("使用第二个方法排序后的list1-----------");
        bubbleSorter.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i1=Integer.parseInt(o1);
                Integer i2=Integer.parseInt(o2);
                return i1>i2?1:0;
            }
        });
        for (int i = 0; i < list1.length; i++) {
            String s = list1[i];
            System.out.print(s+",");
        }
    }
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped=true;
        for (int i = 1,len=list.length; i <len && swapped ; i++) {
            swapped=false;
            for (int j = 0; j < len - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j+1]=temp;
                    swapped=true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
