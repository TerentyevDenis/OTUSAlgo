package Sorting;

public class HeapSort {
    int[] arr;

    void moveMaxToRoot(int root, int size) {
        int l = 2 * root + 1;
        int r = 2 * root + 2;
        int max = root;
        if (l < size && arr[max] < arr[l]) {
            max = l;
        }
        if (r < size && arr[max] < arr[r]) {
            max = r;
        }
        if (max == root) return;
        swap(max, root);
        moveMaxToRoot(max, size);
    }

    void swap(int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }

    public void sort(int[] arr) {
        this.arr = arr;

        for (int root = arr.length / 2 - 1; root >= 0; root--) {
            moveMaxToRoot(root, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i);
            moveMaxToRoot(0, i);
        }
    }


}
