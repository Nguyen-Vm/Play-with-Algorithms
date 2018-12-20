package sorting.basic.shell;

import sorting.SortHelper;

import java.util.Arrays;

/**
 * @author RWM
 * @date 2018/12/19
 */
public class Main {

    // 比较SelectionSort, InsertionSort, BubbleSort和ShellSort四种排序算法的性能效率
    // ShellSort是这四种排序算法中性能最优的排序算法
    public static void main(String[] args) {
        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.basic.selection.SelectionSort", arr1);
        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr2);
        SortHelper.testSort("sorting.basic.bubble.BubbleSort", arr3);
        SortHelper.testSort("sorting.basic.shell.ShellSort", arr4);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.basic.selection.SelectionSort", arr1);
        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr2);
        SortHelper.testSort("sorting.basic.bubble.BubbleSort", arr3);
        SortHelper.testSort("sorting.basic.shell.ShellSort", arr4);
    }
}
