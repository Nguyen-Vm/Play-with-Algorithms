package sorting.basic.insertion;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class InsertionSortAdvance {

    private InsertionSortAdvance() {
    }

    public static void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 寻找arr[i]合适的插入位置

            // 写法3
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && SortHelper.less(temp, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;

        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
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
