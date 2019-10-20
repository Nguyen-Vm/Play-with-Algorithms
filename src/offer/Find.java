package offer;

/**
 * @author RWM
 * @date 2019/10/12
 */
public class Find {


    public static boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 9, 12}};

        System.out.println(find(8, array));
    }
}
