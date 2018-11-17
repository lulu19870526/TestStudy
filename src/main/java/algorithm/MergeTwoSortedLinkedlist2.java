package algorithm;

//合并两个排序的链表
public class MergeTwoSortedLinkedlist2 {

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

        ListNode result = merge2(node1, node4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode merge2(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        ListNode head=null;
        ListNode pNode=null;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                if(head==null) {
                    head=list1;
                    pNode=list1;
                }else {
                    pNode.next=list1;
                    pNode=pNode.next;
                }
                list1=list1.next;
            }else {
                if(head==null) {
                    head=list2;
                    pNode=list2;
                }else {
                    pNode.next=list2;
                    pNode=pNode.next;
                }
                list2=list2.next;
            }
        }
        if(list1==null)
            pNode.next=list2;
        else
            pNode.next=list1;
        return head;
    }
}
