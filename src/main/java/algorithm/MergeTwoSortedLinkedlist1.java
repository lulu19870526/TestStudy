package algorithm;

class ListNode{
    int val;
    ListNode next=null;
    public ListNode(int val) {
        this.val=val;
    }
}
//合并两个排序的链表
public class MergeTwoSortedLinkedlist1 {

    public static ListNode MergerTwoSortedLinkedlist(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }else if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        if (list1.val < list2.val) {
            result = list1;
            result.next = MergerTwoSortedLinkedlist(list1.next, list2);
        } else {
            result = list2;
            result.next = MergerTwoSortedLinkedlist(list1, list2.next);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);

        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode result = MergerTwoSortedLinkedlist(node1, node4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}


