package heap;

/**
 * @author RWM
 * @date 2018/12/24
 */
// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // heapify
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 <= n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }

            if (arr[k].compareTo(arr[j]) >= 0) break;
            swap(arr, k, j);
            k = j;
        }
    }
}
