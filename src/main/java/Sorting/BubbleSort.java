package Sorting;

public class BubbleSort {
    public static void optimizedBubbleSort(int[] arr) {
        boolean needIteration = true;
        int n = arr.length;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    needIteration = true;
                }
            }
            n--;
        }
    }

}
