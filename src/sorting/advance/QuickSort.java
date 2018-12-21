package sorting.advance;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/21
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) return;
        int j = partition(arr, left, right);
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, left , (int)(Math.random()*(right-left+1))+left );

        Comparable v = arr[left];

        int i = left;
        int j = right + 1;

        while (true) {
            while (SortHelper.less(arr[++i], v)) {
                if (i >= right) break;
            }

            while (SortHelper.less(v, arr[--j])) {
                if (j <= left) break;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, left, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortHelper.generateRandomArray(20, 0, 20);
        sort(arr);
    }
}
