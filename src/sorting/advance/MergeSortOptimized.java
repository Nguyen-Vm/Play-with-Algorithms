package sorting.advance;

import sorting.SortHelper;
import sorting.basic.insertion.InsertionSortAdvance;

/**
 * @author RWM
 * @date 2018/12/20
 */
public class MergeSortOptimized {

    private MergeSortOptimized() {
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Integer[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int left, int right) {

        if (right - left <= 15) {
            InsertionSortAdvance.sort(arr, left, right);
            return;
        }

        int middle = left + (right - left) / 2;
        sort(arr, aux, left, middle);
        sort(arr, aux, middle + 1, right);
        if (SortHelper.less(arr[middle + 1], arr[middle])) {
            merge(arr, aux, left, middle, right);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int left, int middle, int right) {

        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }

        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                arr[k] = aux[j++];
            } else if (j > right) {
                arr[k] = aux[i++];
            } else if (SortHelper.less(aux[i], aux[j])) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }

    }

    public static void main(String[] args) {
        Comparable[] arr = SortHelper.generateRandomArray(20, 0, 20);
        sort(arr);
        assert SortHelper.isSorted(arr);
    }
}
