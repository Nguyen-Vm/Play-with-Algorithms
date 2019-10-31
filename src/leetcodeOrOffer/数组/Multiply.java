package leetcodeOrOffer.数组;

/**
 * 乘积数组
 */
public class Multiply {

    public int[] multiply(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        for (int i = 1; i < length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp = temp * a[i+1];
            b[i] = b[i] * temp;
        }
        return b;
    }
}
