package sorting.advance;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/20
 */
public class MergeSortBU {

    private MergeSortBU() {
    }

    public static void sort(Comparable[] arr) {

        Comparable[] aux = new Integer[arr.length];

        int n = arr.length;

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, aux, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
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
