package sorting.basic.selection;

import sorting.basic.SortTestHelper;

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
                if (arr[j].compareTo(arr[mixIndex]) < 0) {
                    mixIndex = j;
                }
            }
            swap(arr, i, mixIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int N = 2000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 1000);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr);
    }
}
