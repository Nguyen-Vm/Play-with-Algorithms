package leetcodeOrOffer.二叉树;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        System.out.println(treeDepth(root));
    }

}
