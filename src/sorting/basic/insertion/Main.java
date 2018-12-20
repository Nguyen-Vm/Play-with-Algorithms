package sorting.basic.insertion;

import sorting.basic.SortTestHelper;

import java.util.Arrays;

/**
 * @author RWM
 * @date 2018/12/19
 */
public class Main {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    public static void main(String[] args) {
        int N = 10000;
        System.out.println(String.format("Test for random array, size = %s, random range [0, %s]", N, N));

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        // 此时，插入排序比选择排序性能略低
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        // 优化后，插入排序比选择排序性能略好
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr3);


        // 测试2 有序性更强的测试
        System.out.println();
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr3);

        // 对于有序性强的数组，插入排序远远优于选择排序
        int swapTimes = 100;

        System.out.println();
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sorting.basic.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sorting.basic.selection.SelectionSort", arr2);
        SortTestHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr3);

    }
}
