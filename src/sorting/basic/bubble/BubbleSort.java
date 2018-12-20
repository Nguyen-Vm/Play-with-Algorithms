package sorting.basic.bubble;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (!SortHelper.less(arr[i - 1], arr[i])) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }

            n--;

        } while (swapped);

    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortHelper.generateRandomArray(100, 0, 100);
        sort(arr);
        assert SortHelper.isSorted(arr);
    }
}
