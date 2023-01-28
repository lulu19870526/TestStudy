package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/23 18:45
 */
public class NC40 {

    public static void main(String[] args){
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);

        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(3);

        ListNode node = addInList(head1,head2);
    }

    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode node1 = reverseList(head1);
        ListNode node2 = reverseList(head2);
        ListNode dummy = new ListNode(-1);
        ListNode node3 = dummy;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int temp1 = node1 != null ? node1.val : 0;
            int temp2 = node2!= null ? node2.val : 0;
            int tempSum = temp1 + temp2 + carry;
            ListNode  newNode = new ListNode(tempSum % 10);
            carry = tempSum / 10;
            node3.next = newNode;
            node3 = newNode;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }

        }
        if (carry != 0) {
            ListNode  newNode = new ListNode(carry);
            node3.next = newNode;
        }

        return reverseList(dummy.next);
    }

    private static ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = node;
        while (current !=  null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}

class ListNode {
   int val;
   ListNode next = null;

   ListNode(int val){
      this.val = val;
   }
}
