package leetcodeOrOffer.二叉树;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历重建二叉树
 *
 * @author RWM
 * @date 2019/10/23
 */
public class ReconstructBinaryTree {

    public static TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        if (pre.length == 1) {
            return root;
        }
        int rootIdx = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        root.left = reconstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIdx + 1), Arrays.copyOfRange(in, 0, rootIdx));
        root.right = reconstructBinaryTree(Arrays.copyOfRange(pre, rootIdx + 1, pre.length), Arrays.copyOfRange(in, rootIdx + 1, in.length));
        return root;

    }
}