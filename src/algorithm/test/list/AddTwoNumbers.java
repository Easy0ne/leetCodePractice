package algorithm.test.list;

/**
 * @author wangzk
 * @date 2020-02-27 20:14
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result_head = new ListNode(0);
        ListNode result = result_head;
        int num1 = 0, num2 = 0;
        int x = 0;
        boolean flag_incr1 = false;
        while (l1 != null || l2 != null) {
            num1 = l1==null ? 0 : l1.val;
            num2 = l2==null ? 0 : l2.val;
            x = num1 + num2;
            if (flag_incr1) { x += 1; }
            if (x < 10) {
                result.next = new ListNode(x);
                flag_incr1 = false;
            } else {
                result.next = new ListNode(x%10);
                flag_incr1 = true;
            }
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
            result = result.next;
        }
        if(flag_incr1) result.next = new ListNode(1);
        return result_head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, cur = head;
        int carry = 0;
        while (p != null || q != null){
            int num1 = p==null ? 0 : p.val;
            int num2 = q==null ? 0 : q.val;
            int x = num1 + num2 + carry;
            carry = x/10;
            cur.next = new ListNode(x % 10);
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            cur = cur.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return head.next;
    }

    public void test(){
        int[] a1 = {7,5,2,1};
        int[] a2 = {6,2};
        ListNode l1 = ListNode.array2List(a1);
        ListNode l2 = ListNode.array2List(a2);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(ListNode.list2String(result));

        int[] a3 = {5};
        int[] a4 = {5};
        System.out.println(ListNode.list2String(addTwoNumbers2(ListNode.array2List(a3), ListNode.array2List(a4))));
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.test();
    }
}
