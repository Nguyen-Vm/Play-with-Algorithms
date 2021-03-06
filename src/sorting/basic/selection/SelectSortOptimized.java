package sorting.basic.selection;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class SelectSortOptimized {

    private SelectSortOptimized() {
    }

    public static void sort(Comparable[] arr) {

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            if (SortHelper.less(arr[maxIndex], arr[minIndex])) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (SortHelper.less(arr[i], arr[minIndex])) {
                    minIndex = i;
                } else if (SortHelper.less(arr[maxIndex], arr[i])) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
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
