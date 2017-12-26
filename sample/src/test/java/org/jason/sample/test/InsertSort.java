package org.jason.sample.test;

public class InsertSort {
    public static void main (String[] args){
        int[] a=new int[]{20,25,7,1,23,15,12,17,99};
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
        for (int k = 0; k < a.length; k++) {
            int i1 = a[k];
            System.out.print(i1+",");
        }
    }
}
