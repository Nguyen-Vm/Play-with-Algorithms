package heap;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/24
 */
public class HeapSort2 {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000000;

        Integer[] arr = SortHelper.generateRandomArray(N, 0, N);
        SortHelper.testSort("heap.HeapSort2", arr);
    }

}
