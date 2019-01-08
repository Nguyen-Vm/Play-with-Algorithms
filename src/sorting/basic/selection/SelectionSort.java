package sorting.basic.selection;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mixIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (SortHelper.less(arr[j], arr[mixIndex])) {
                    mixIndex = j;
                }
            }
            swap(arr, i, mixIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int N = 2000;
        Integer[] arr = SortHelper.generateRandomArray(N, 1, 1000);
        SortHelper.testSort("sorting.basic.selection.SelectionSort", arr);
    }
}
