package Sorts.InsertionSort;

import java.util.Arrays;

public class Main {
    private static void insertionSort(int[] arr) {
        for(int i = 1;i < arr.length;i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 5, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
