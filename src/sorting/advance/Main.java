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
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

//        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr1);
        SortHelper.testSort("sorting.advance.MergeSort", arr2);
        SortHelper.testSort("sorting.advance.MergeSortOptimized", arr3);
        SortHelper.testSort("sorting.advance.QuickSort", arr4);

        System.out.println();

        arr1 = SortHelper.generateRandomArray(N, 0,10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

//        SortHelper.testSort("sorting.basic.insertion.InsertionSortAdvance", arr1);
        SortHelper.testSort("sorting.advance.MergeSort", arr2);
        SortHelper.testSort("sorting.advance.MergeSortOptimized", arr3);
        SortHelper.testSort("sorting.advance.QuickSort", arr4);
    }
}
