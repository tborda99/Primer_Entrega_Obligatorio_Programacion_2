import MyTADS.Entities.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,2,9,1,3};
        int[] arr2 = {5,2,9,1,3};
        QuickSort.quickSort(arr,0,arr.length-1,false);
        QuickSort.quickSort(arr2,0,arr.length-1,true);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}