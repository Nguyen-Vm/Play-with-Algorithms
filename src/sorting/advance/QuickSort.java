package sorting.advance;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2018/12/21
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) return;
        int j = partition(arr, left, right);
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        // 标定点pivot，或者中心点
        Comparable v = arr[left];

        int i = left;
        int j = right + 1;

        while (true) {
            // 从左往右查找，找到大于标定点值的位置i
            while (SortHelper.less(arr[++i], v)) {
                if (i >= right) break;
            }

            // 从右往左查找，找到小于标定点值得位置j
            while (SortHelper.less(v, arr[--j])) {
                if (j <= left) break;
            }

            // 如果i，j相遇，退出循环
            if (i >= j) {
                break;
            }

            // 将i和j位置互换，相当于小于v的左移，大于v的右移
            swap(arr, i, j);
        }

        // 标定点再和j交换位置，这样标定点大于所有左边的数，小于所有右边的数
        swap(arr, left, j);

        // 返回标定点的位置，再对标定点左右两边做类似处理后，数组就是有序的
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortHelper.generateRandomArray(20, 0, 20);
        sort(arr);
    }
}
