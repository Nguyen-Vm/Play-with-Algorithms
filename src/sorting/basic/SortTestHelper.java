package sorting.basic;

import java.lang.reflect.Method;

/**
 * @author RWM
 * @date 2018/12/18
 */
public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    /**
     * 生个n个元素的随机数组，每个元素的随机范围为[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }

        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * 首先生成一个含有[0， n-1]的完全有序数组，之后随机交换swapTimes对数据
     * swapTimes定义了数组的无需程度：
     * swapTimes=0时，数组完全有序
     * swapTimes越大，数组越趋向于无序
     * @param n
     * @param swapTimes
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    // 打印arr数组
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        try {

            Class sortClass = Class.forName(sortClassName);

            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();

            sortMethod.invoke(null, params);

            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
