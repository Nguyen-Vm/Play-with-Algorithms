package offer;

/**
 * @author RWM
 * @date 2019/10/15
 */
public class Add {

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;// 不考虑进位加法，异或运算
            num2 = (num1 & num2) << 1;// 加法进位，与运算左移1位
            num1 = temp;
        }// 重复进行加法直到进位为0
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 7));
    }
}
