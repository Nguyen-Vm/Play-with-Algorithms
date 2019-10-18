package sorting.advance;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/20
 */
public class MergeSort {

    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int left, int right) {
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        sort(arr, aux, left, middle);
        sort(arr, aux, middle + 1, right);
        merge(arr, aux, left, middle, right);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int l, int m, int r) {

        for (int k = l; k <= r; k++) {
            aux[k] = arr[k];
        }

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) < 0) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        Comparable[] arr = SortHelper.generateRandomArray(20000, 0, 20000);
        sort(arr);
        assert SortHelper.isSorted(arr);
    }
}
