package sorting.advance;

import sorting.SortHelper;

/**
 * 快速排序的核心思想：
 * 1. 需要三个重要元素（左指针，右指针，基准数key[一般采用数组的第一个元素作为基准数]）
 * 2. 如果采用数组的第一个数据作为基准数，那么需要先右指针向前移动，直到找到比key小的数据停下。
 * 3. 然后左指针向后移动，直到找到比key大的数据停下
 * 4. 然后将左右指针所指向的数据做交换
 * 5. 重复上面的动作，直到左右指针重合 ，最后将左指针或右指针的数据与key所在位置的数组值（arr[start]）交换,
 *    不能与key本身做交换，因为如果带排序数组中有重复数据的时候，会出现错误。因为key是额外的变量，与key交换达不到修改数组的目的。
 *
 * @author RWM
 * @date 2019/10/9
 */
public class QuickSort2Ways {

    public static void main(String[] args) {
        Integer[] arr = {2, 4, 6, 8, 1, 5, 0, 1, 1, 1};
        sort(arr);
        SortHelper.printArray(arr);
    }

    public static void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Integer[] arr, int start, int end) {
        /*
         * 必须要判断start是否大于end,因为即使我们自己输入的时候没有错误现象，
         * 但是方法中调用了递归，我们控制不了递归的传参，所以在执行递归的时候，
         * 有可能会出现参数不合理输入的情况，所以需要判断*/
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int key = arr[start];
        while (left < right) {

            /*
             * 右指针向前移
             * 因为选取的左边第一个为基准数key,所以要从数组的右边开始遍历。
             * 一定要判断当前的数据是否等于key的值arr[right] >= key，否则会出现重复替换多次的现象*/
            while (left < right && arr[right] >= key) {
                right--;
            }

            /*
             * 左指针向后移*/
            while (left < right && arr[left] <= key) {
                left++;
            }

            /*
             * 将左右指针的数据进行交换*/
            if (left < right) {
                swap(arr, left, right);
            }
        }
        /*
         * 将两指针相遇时的值（arr[left]或arr[right]）和key所在位置的数组值（arr[start]）交换,
         * 不能与key本身做交换，因为如果带排序数组中有重复数据的时候，会出现错误。
         * 因为key是额外的变量，与key交换达不到修改数组的目的*/
        arr[start] = arr[left];
        arr[left] = key;

        /*
         * 递归遍历基准key的左边和右边*/
        quickSort(arr, start, left - 1);
        quickSort(arr, right + 1, end);

    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}