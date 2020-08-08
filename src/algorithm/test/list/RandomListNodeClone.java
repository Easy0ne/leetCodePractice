package algorithm.test.list;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-03 10:05
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeClone {
    /*
    random可能指向某个next，递归方法使用map来记录某个节点是否已克隆过，保持节点唯一性。
     */
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode pClonedNode = new RandomListNode(pHead.label);
        map.put(pHead, pClonedNode);
        if (!map.containsKey(pHead.next)) {
            pClonedNode.next = Clone(pHead.next);
        } else {
            pClonedNode.next = map.get(pHead.next);
        }
        if (!map.containsKey(pHead.random)) {
            pClonedNode.random = Clone(pHead.random);
        } else {
            pClonedNode.random = map.get(pHead.random);
        }
        return pClonedNode;
    }


    /*
    相比于用map保存<旧节点-新节点>的方法，复制拆分法直接将新节点放在旧节点的后面，也可以起到映射的作用。
    该题中的random都是指向next链中的节点。
    1.沿着next链复制节点A，并将新节点A1插入到原节点A后面；
    2.更新A1的random，A1.random = A.random.next
    3.拆分，将链表拆分成原链表和复制后的链表
     */
    public RandomListNode Clone_Optm(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode clonedNode = new RandomListNode(node.label);
            clonedNode.next = node.next;
            node.next = clonedNode;
            node = clonedNode.next;
        }

        node = pHead;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }

        //此处只拆分出新链表，也可新增引用将旧链表的链保存下来
        node = pHead.next;
        while (node.next != null) {
            node.next = node.next.next;
            node = node.next;
        }
        return pHead.next;
    }


    public void printRandomNodeList(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            if (node.random != null)
                System.out.print(node.label + "\t" + node.random.label + "\t");
            else
                System.out.print(node.label + "\t" + "#" + "\t");
            node = node.next;
        }
    }

    @Test
    public void test() {
        RandomListNode node0 = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node0.next = node1;
        node0.random = node2;

        node1.next = node2;
        node1.random = node3;

        node2.next = node3;
        node2.random = null;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node1;

        node5.random = node4;

        printRandomNodeList(node0);
        System.out.println();

        RandomListNodeClone rClone = new RandomListNodeClone();

        RandomListNode cloneListNode = rClone.Clone(node0);
        printRandomNodeList(cloneListNode);
        System.out.println();

        RandomListNode cloneListNode1 = rClone.Clone_Optm(node0);
        printRandomNodeList(cloneListNode1);
        System.out.println();

//        RandomListNode node = cloneListNode1;
//        while (node != null) {
//            System.out.println(node.label);
//            node = node.next;
//        }
    }
}
