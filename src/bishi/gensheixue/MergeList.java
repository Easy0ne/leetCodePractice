package bishi.gensheixue;

import org.junit.Test;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-08-07 19:44
 */

class Node {
    int data;
    Node next;
}

class Solution {
    public Node mergeTwoLists(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        Node head = new Node();
        Node result = head;
        while (n1 != null && n2 != null) {
            Node nextNode = new Node();
            if (n1.data < n2.data) {
                nextNode.data = n1.data;
                n1 = n1.next;
            } else {
                nextNode.data = n2.data;
                n2 = n2.next;
            }
            result.next = nextNode;
            result = result.next;
        }

        while (n1 != null) {
            result.next = n1;
            n1 = n1.next;
            result = result.next;
        }

        while (n2 != null) {
            result.next = n2;
            n2 = n2.next;
            result = result.next;
        }

        return head.next;
    }
}

public class MergeList {

    @Test
    public void test() {
        Node node1 = new Node(); node1.data = 1;
        Node node2 = new Node(); node2.data = 2;
        Node node3 = new Node(); node3.data = 4;
        node1.next = node2; node2.next = node3;

        Node node4 = new Node(); node4.data = 1;
        Node node5 = new Node(); node5.data = 3;
        Node node6 = new Node(); node6.data = 4;
        node4.next = node5; node5.next = node6;

        Solution solution = new Solution();
        Node result = solution.mergeTwoLists(node1, node4);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }

    }
}