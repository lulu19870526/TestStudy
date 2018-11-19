package algorithm;

public class Reverse {

    //反转链表，需要记录三个结点：当前结点、它的前一个结点及后一个结点
    static ListNode reverseLinkedList(ListNode node) {
        ListNode previousNode = null;
        ListNode currentNode = node;
        ListNode headNode = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }
}
