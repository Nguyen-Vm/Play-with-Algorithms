package sorting.basic.insertion;

import sorting.basic.SortTestHelper;

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


            // 写法2
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
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
        Integer[] arr = SortTestHelper.generateRandomArray(1000, 1, 1000);
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr);
    }
}
