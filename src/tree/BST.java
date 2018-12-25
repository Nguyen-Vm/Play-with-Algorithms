package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RWM
 * @date 2018/12/25
 */
// 二分搜索树
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    /**
     * 二分搜索树的节点个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 二分搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 二分搜索树中是否存在键Key
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 在二分搜索树中搜索键Key所对应的值。如果这个键Key不存在，则返回null
     *
     * @param key
     * @return
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 向二分搜索树中插入一个新的（Key， Value）数据对
     *
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();

            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 寻找最小的键值
     *
     * @return
     */
    public Key minimum() {
        assert (!isEmpty());
        Node minNode = minimum(root);
        return minNode.key;
    }

    /**
     * 寻找最大的键值
     *
     * @return
     */
    public Key maximum() {
        assert (!isEmpty());
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 从二叉树中删除最小值所在节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 从二叉树中删除最大值所在节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 从二叉树中删除键值为key的节点
     *
     * @param key
     */
    public void remove(Key key) {
        assert contain(key);
        root = remove(root, key);
    }

    // 删除掉以node为根的二分搜索树中键值为Key的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, Key key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // key == node->key
            if (node.left == null) {
                Node rightNode = node.right;
                count--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                count--;
                return leftNode;
            }

            // node->left != null && node->right != null
            Node successor = new Node(minimum(node.right));
            successor.left = node.left;
            successor.right = removeMin(node.right);
            count--;

            return successor;
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }


    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        boolean empty = bst.isEmpty();
        int size = bst.size();
        bst.insert(5, String.valueOf(5) + "value");
        bst.insert(3, String.valueOf(3) + "value");
        bst.insert(2, String.valueOf(2) + "value");
        bst.insert(7, String.valueOf(7) + "value");
        bst.insert(8, String.valueOf(8) + "value");
        bst.insert(6, String.valueOf(6) + "value");
        bst.insert(4, String.valueOf(4) + "value");

        boolean contain = bst.contain(5);
        String search = bst.search(5);
        empty = bst.isEmpty();
        size = bst.size();

        Integer minimum = bst.minimum();
        Integer maximum = bst.maximum();

        bst.inOrder();

        System.out.println();

        bst.removeMin();
        bst.inOrder();

        System.out.println();

        bst.removeMax();
        bst.inOrder();

        System.out.println();

//        bst.preOrder();
//        bst.inOrder();
//        bst.postOrder();
//        bst.levelOrder();
    }
}
