package algorithm;

//两个链表的第一个公共结点
public class FirstCommonNode {

    /**
     * 首先需要得到 L1的长度 和 L2的长度，
     * 让较长的那个先走 （length1-length2）步。然后再一直next去判断。
     * @param root1
     * @param root2
     * @return
     */
    public static ListNode findFirstCommonNode(ListNode root1, ListNode root2) {

        ListNode resultNode = null;
        int length1 = getLength(root1);
        int length2 = getLength(root2);

        ListNode LongList;
        ListNode ShortList;
        int steps = 0;
        if (length1 > length2) {
            LongList = root1;
            ShortList = root2;
            steps = length1 - length2;
        } else {
            LongList = root2;
            ShortList = root1;
            steps = length2 - length1;
        }

        for (int i = 0; i < steps; i++) {
            LongList = LongList.next;
        }

        while (LongList != null && ShortList != null && LongList != ShortList) {
            LongList = LongList.next;
            ShortList = ShortList.next;
        }
        resultNode = LongList;
        return resultNode;
    }


    public static int getLength(ListNode pHead) {
        int length = 0;
        ListNode current = pHead;
        while (current != null) {
              length++;
              current = current.next;
        }
        return length;
    }
}
