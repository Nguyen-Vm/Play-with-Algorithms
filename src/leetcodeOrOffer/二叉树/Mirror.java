package leetcodeOrOffer.二叉树;

/**
 * 二叉树的镜像
 *
 * @author RWM
 * @date 2019/10/21
 */
public class Mirror {

    public static void mirror(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
