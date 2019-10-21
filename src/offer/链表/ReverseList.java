package offer.链表;

/**
 * 反转链表
 *
 * @author RWM
 * @date 2019/10/21
 */
public class ReverseList {

    public static ListNode reverse(ListNode head) {
        // 指向当前正在反转的结点
        ListNode p = null;
        // 指向游离的反转链表
        ListNode q = null;
        while (head != null) {
            // 从head开始反转
            p = head;
            // head下移
            head = head.next;
            // 断开原指针，指向反转链表
            p.next = q;
            // p节点已反转，q指已反转链表头结点
            q = p;
        }
        // 返回所有已反转链表头结点
        return q;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = reverse(node1);
        System.out.println(reverse);
    }
}
