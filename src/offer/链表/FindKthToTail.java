package offer.链表;

/**
 * 链表中倒数第k个结点
 *
 * @author RWM
 * @date 2019/10/21
 */
public class FindKthToTail {

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode findKthToTailV2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        for (; fast != null; i++) {
            fast = fast.next;
            if (i >= k) {
                slow = slow.next;
            }
        }
        return i < k ? null : slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = findKthToTail(head, 5);
        System.out.println(node == null ? node : node.val);
    }
}
