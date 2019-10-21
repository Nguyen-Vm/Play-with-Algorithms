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
}
