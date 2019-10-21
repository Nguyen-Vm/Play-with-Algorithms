package leetcodeOrOffer.链表;

/**
 * 链表结点
 *
 * @author RWM
 * @date 2019/10/21
 */
public class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(val);
        ListNode head = this;
        while (head.next != null) {
            sb.append("->").append(head.next.val);
            head = head.next;
        }
        return sb.toString();
    }
}
