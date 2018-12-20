package sorting.basic.shell;

import sorting.basic.SortTestHelper;

/**
 * @author RWM
 * @date 2018/12/19
 */
public class ShellSort {

    private ShellSort() {
    }

    /**
     * 希尔排序是插入排序的一种
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {

            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable temp = arr[i];
                int j = i;
                for (; j >= h && temp.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 10);
        sort(arr);
        assert SortTestHelper.isSorted(arr);
    }
}
