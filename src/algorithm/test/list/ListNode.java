package algorithm.test.list;

/**
 * @author wangzk
 * @date 2020-02-27 18:54
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x){val = x;}
     public ListNode(int x, ListNode next){this.val=x; this.next=next;}

    @Override
     public String toString(){
         return "ListNode [val=" +val+ "]";
     }

     public static String list2String(ListNode head){
         if(head == null){
             return "";
         }
         StringBuilder sb = new StringBuilder();
         while (head.next != null){
             sb.append(head.val);
             head = head.next;
         }
         sb.append(head.val);
         return sb.toString();
     }

     public static ListNode array2List(int[] arr){
         ListNode head = new ListNode(0);
         ListNode node = head;
         for (int i: arr){
             node.next = new ListNode(i);
             node = node.next;
         }
         return head.next;
     }

    public void test(){
         int[] arr={1,2,3};
         ListNode list = ListNode.array2List(arr);
         String strList = ListNode.list2String(list);
         System.out.println(strList);
    }

    public static void main(String[] args){
         ListNode list = new ListNode(0);
         list.test();
    }
}