package DataStructure;

import java.util.Comparator;

/**
 * @Author:Jason
 * @Description:二分查找(在有序数组中查找某一特定元素的搜索算法)
 * @Date:Created in 15:48 2017/12/27
 * @Modified By:
 */
public class BinarySearch {

    public static void main (String[] args){
        Integer[] ary={1,2,3,4,5,6,7,8,9,10};
        //方法返回元素在数组中的下标
        int index=-1;
        System.out.println(index=binarySearch(ary, 0, 9, 3));
        System.out.println(ary[index]);
    }
    //使用递归实现二分查找
    public static <T extends Comparable<T>> int binarySearch(T[] x,int low,int high,T key){
        if (low < high) {
            //中间位
            int mid = low + (high - low) / 2;
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid])<0) {
                return binarySearch(x, low, mid - 1, key);
            }else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }
}
