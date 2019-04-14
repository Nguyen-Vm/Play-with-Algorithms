package array;

import sorting.SortHelper;

/**
 * @author RWM
 * @date 2019/4/14
 */
public class ArrayInversion {

    public static void main(String[] args) {
        Integer[] array = SortHelper.generateNearlyOrderedArray(13, 0);
        SortHelper.printArray(array);
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length -1 - i] = temp;
        }
        SortHelper.printArray(array);
    }
}
