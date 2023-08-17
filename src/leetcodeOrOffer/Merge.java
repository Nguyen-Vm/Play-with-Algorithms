package leetcodeOrOffer;

/**
 * 合并两个有序数组
 *
 * @author 阮威敏
 * @date 2023/8/17
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int p = m + n - 1; p1 >= 0 && p2 >= 0; p--) {
            int val1 = nums1[p1];
            int val2 = nums2[p2];
            if (val1 >= val2) {
                nums1[p] = val1;
                p1--;
            } else {
                nums1[p] = val2;
                p2--;
            }
        }
        if (p1 < 0) {
            for (int i = 0; i <= p2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
