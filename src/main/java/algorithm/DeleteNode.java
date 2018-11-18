package algorithm;

//在O(1)时间删除链表结点
public class DeleteNode {

    public static ListNode delete(ListNode head, ListNode toBeDelete){
        if(head == null || toBeDelete == null){
            return null;
        }

        //不是尾结点
        //将待删除结点的下一个结点的值赋给待删除的结点，然后删除一个结点，就达到了删除结点的目的
        if(toBeDelete.next != null){
            ListNode node = toBeDelete.next;
            toBeDelete.val = node.val;
            toBeDelete.next = node.next;

            node = null;

        }
        //只有一个结点，删除头结点
        else if(head == toBeDelete){
            toBeDelete = null;
            head = null;
            return null;
        }
        //多个结点，删除尾结点
        else{
            ListNode node = head;
            while(node.next != toBeDelete){
                node = node.next;
            }

            node.next = null;
            toBeDelete = null;
        }
        return head;

    }

}
