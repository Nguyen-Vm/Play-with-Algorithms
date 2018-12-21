package sorting.advance;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/21
 */
public class QuickSort3Ways {

    private QuickSort3Ways() {
    }

    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) return;

        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        Comparable v = arr[left];


        int lt = left;// arr[l+1...lt] < v
        int gt = right + 1;// arr[gt...r] > v
        int i = left + 1;// arr[lt+1...i] == v

        while (i < gt) {
            if (SortHelper.less(arr[i], v)) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (SortHelper.less(v, arr[i])) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }

        swap(arr, left, lt);

        sort(arr, left, lt - 1);
        sort(arr, gt, right);


    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortHelper.generateRandomArray(20, 0, 20);
        sort(arr);
        assert SortHelper.isSorted(arr);
    }
}
