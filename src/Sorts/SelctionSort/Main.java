package Sorts.SelctionSort;

import java.util.Arrays;

public class Main {
    private static void selectionSort(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 5, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
