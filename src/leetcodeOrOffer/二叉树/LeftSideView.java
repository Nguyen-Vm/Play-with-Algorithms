package leetcodeOrOffer.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RWM
 * @date 2019/10/21
 */
public class LeftSideView {

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> leftSideView(TreeNode node) {
        dfs(node, 1);
        return ans;
    }

    private static void dfs(TreeNode node, int i) {
        if (node == null) {
            return;
        }
        if (ans.size() < i) {
            ans.add(node.val);
        }
        dfs(node.left, i + 1);
        dfs(node.right, i + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        System.out.println(leftSideView(root));
    }
}
