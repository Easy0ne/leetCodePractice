package exam.gensheixue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListNodeCommon {

    public static class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static Node getCommon(Node headA, Node headB) {
        Stack<Node> stackA = new Stack<>();
        Stack<Node> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        Node nodeA=null, nodeB=null;
        while (stackA.peek() == stackB.peek()) {
            nodeA = stackA.pop();
            nodeB = stackB.pop();
        }
        return nodeA;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Node headA = null;
        Node headB = null;

        Map<String, Node> map = new HashMap<String, Node>();

        if (line1 != null && line1.length() > 0) {
            String[] array1 = line1.split(",");
            headA = new Node();
            headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
            map.put(array1[0], headA);
            Node pre = headA;
            for (int i = 1; i < array1.length; i++) {
                Node node = map.get(array1[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
                    map.put(array1[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }
        if (line2 != null && line2.length() > 0) {
            String[] array2 = line2.split(",");
            headB = map.get(array2[0]);
            if (headB == null) {
                headB = new Node();
                headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
                map.put(array2[0], headB);
            }
            Node pre = headB;
            for (int i = 1; i < array2.length; i++) {
                Node node = map.get(array2[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
                    map.put(array2[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }

        Node res = getCommon(headA, headB);
        System.out.println(res == null ? res : res.getData());
    }
}

