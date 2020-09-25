package exam.taledu;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/20 14:23
 */

class ListNode {
    int val;
    ListNode next = null;

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
}


public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode(); node1.val = 1; head.next = node1;
        ListNode node2 = new ListNode(); node2.val = 2; node1.next = node2;
        ListNode node3 = new ListNode(); node3.val = 3; node2.next = node3;
        ListNode node4 = new ListNode(); node4.val = 4; node3.next = node4;
        ListNode node = head.next;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        ReverseList reverseList = new ReverseList();
        head = reverseList.reverseList(head);

        node = head.next;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }


    /**
     * 逆序
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode reverseList (ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        // write code here
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode headNext = head.next;
            ListNode nodeNext = node.next;
            head.next = node;
            node.next = headNext;
            node = nodeNext;
        }
        return head;
    }
}
