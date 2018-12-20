package sorting.basic.selection;

import sorting.basic.SortTestHelper;

import java.util.Arrays;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class Main {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    public static void main(String[] args) {
        int N = 20000;

        // 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortTestHelper.testSort("sorting.basic.selection.SelectSortOptimized", arr3);


        // 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println();
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + N);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr2.length);
        arr3 = Arrays.copyOf(arr1, arr2.length);
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortTestHelper.testSort("sorting.basic.selection.SelectSortOptimized", arr3);


        System.out.println();

    }
}
