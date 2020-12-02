package Sorting;

public class InsertionSort {
    public static void optimizedInsertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            int low = 0;
            int hi = i;
            int mid;
            while (low < hi) {
                mid = low + (hi - low) / 2;
                if (elem < arr[mid]) {
                    hi = mid;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = elem;
        }
    }

}
