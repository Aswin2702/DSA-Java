package Sorts.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 2};
        int[] arr2 = {2, 4, 5, 16};
        System.out.println(Arrays.toString(mergeSort(arr1)));
    }
    private static int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0, i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            combined[index++] = arr2[j++];
        }
        return combined;
    }
}
