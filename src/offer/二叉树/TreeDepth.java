package offer.二叉树;

/**
 * 二叉树的深度
 *
 * @author RWM
 * @date 2019/10/21
 */
public class TreeDepth {

    public static int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftDepth = treeDepth(node.left);
        int rightDepth = treeDepth(node.right);
        return Math.max(leftDepth + 1, rightDepth + 1);
    }

}
