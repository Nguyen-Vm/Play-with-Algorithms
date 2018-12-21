package sorting.advance;

import sorting.SortHelper;

import java.util.Arrays;

/**
 * @author RWM
 * @date 2018/12/20
 */
public class Main {

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr1 = SortHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.advance.MergeSort", arr1);
        SortHelper.testSort("sorting.advance.MergeSortOptimized", arr2);
        SortHelper.testSort("sorting.advance.QuickSort", arr3);

        System.out.println();

        arr1 = SortHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.advance.MergeSort", arr1);
        SortHelper.testSort("sorting.advance.MergeSortOptimized", arr2);
        SortHelper.testSort("sorting.advance.QuickSort", arr3);

        System.out.println();

        arr1 = SortHelper.generateNearlyOrderedArray(N, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortHelper.testSort("sorting.advance.MergeSort", arr1);
        SortHelper.testSort("sorting.advance.MergeSortOptimized", arr2);
        SortHelper.testSort("sorting.advance.QuickSort", arr3);
    }
}
