package org.jason.sample.test;

public class QuickSort {
    public static void main (String[] args){
        int[] ints=new int[]{20,25,7,1,23,15,12,17,99};
        sort(ints, 0, 8);
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            System.out.print(anInt+",");
        }
    }
    static void sort(int[] a,int left,int right){
        if(left<right){
            int l=left;
            int r=right;
            int key=a[left];
            while (l < r) {
                while (l < r && a[r] > key) {
                    r--;
                }
                a[l]=a[r];
                while (l < r && a[l] < key) {
                    l++;
                }
                a[r] = a[l];
            }
            a[r]=key;
            sort(a, left, l-1);
            sort(a, r+1, right);
        }
    }
}
