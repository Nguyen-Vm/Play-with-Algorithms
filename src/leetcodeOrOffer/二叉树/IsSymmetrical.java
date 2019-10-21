package leetcodeOrOffer.二叉树;

/**
 * 对称的二叉树
 *
 * @author RWM
 * @date 2019/10/21
 */
public class IsSymmetrical {

    public static boolean isSymmetrical(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isSymmetrical(node.left, node.right);
    }

    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != left.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
