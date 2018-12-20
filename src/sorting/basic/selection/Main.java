package sorting.basic.selection;

import sorting.SortHelper;

import java.util.Arrays;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class Main {

    // 比较SelectionSort和优化后的SelectSortOptimized算法的性能效率
    public static void main(String[] args) {
        int N = 50000;

        /** 优化后的选择排序，速率略高 **/
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr1);
        SortHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortHelper.testSort("sorting.basic.selection.SelectSortOptimized", arr3);


        /** 近乎有序的数组，插入排序远远优于选择排序 **/
        int swapTimes = 100;
        System.out.println();
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + N);

        arr1 = SortHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr2.length);
        arr3 = Arrays.copyOf(arr1, arr2.length);
        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr1);
        SortHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortHelper.testSort("sorting.basic.selection.SelectSortOptimized", arr3);


        System.out.println();

    }
}
