package leetcodeOrOffer.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 *
 * @author RWM
 * @date 2019/10/21
 */
public class PrintListFromTailToHead {

    public static List<Integer> printListFromTailToHead(ListNode node) {
        if (node == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        printListFromTailToHead(node, list);
        return list;
    }

    private static void printListFromTailToHead(ListNode node, List<Integer> list) {
        if (node.next != null) {
            printListFromTailToHead(node.next, list);
        }
        list.add(node.val);
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
        List<Integer> integers = printListFromTailToHead(node1);
        System.out.println(integers);
    }
}
