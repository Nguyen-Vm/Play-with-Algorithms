package leetcodeOrOffer.二叉树;

/**
 * 寻找二叉树中两个节点的最小公共父节点
 *
 * @author RWM
 * @date 2019/10/22
 */
public class FindParent {

    public static TreeNode findParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        if (reachable(root.left, node1) && reachable(root.left, node2)) {
            return findParent(root.left, node1, node2);
        }
        if (reachable(root.right, node1) && reachable(root.right, node2)) {
            return findParent(root.right, node1, node2);
        }
        return root;
    }

    private static boolean reachable(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return reachable(root.left, node) || reachable(root.right, node);
    }
}
