package sorting.basic.insertion;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 寻找arr[i]合适的插入位置

            // 写法1
            /*for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }*/


            // 写法2 arr[j].compareTo(arr[j - 1]) < 0
            for (int j = i; j > 0 && SortHelper.less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }

        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortHelper.generateRandomArray(1000, 1, 1000);
        SortHelper.testSort("sorting.basic.insertion.InsertionSort", arr);
    }
}
