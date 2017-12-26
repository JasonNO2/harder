package DataStructure;

public class QuickSort2 {
    public static void main (String[] args){
        int[] a=new int[]{20,40,88,74,2,5,15,8};
        quickSort(a, 0, 7);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }
    static void quickSort(int[] a,int l,int r){
        if (l < r) {
            int left=l;
            int right=r;
            int key = a[l];
            while (left < right) {
                //从右向左
                while (right > left && a[right] > key) {
                    right--;
                }
                a[left] = a[right];
                while (right > left && a[left] < key) {
                    left++;
                }
                a[right] = a[left];
            }
            //a[left]=key;
            a[right]=key;
            quickSort(a, l, left-1);
            quickSort(a, right+1, r);
        }
    }
}
