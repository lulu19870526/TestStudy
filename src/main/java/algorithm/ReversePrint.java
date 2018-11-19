package algorithm;

//从尾到头打印链表
public class ReversePrint {

    //递归方式，递归在本质上就是一个栈结构
    //先递归输入后面的结点，再输出自身
    public static void printListReverse_recursively(listNode headNode){
        if(headNode!=null)
        {
            if(headNode.next!=null)
            {
                printListReverse_recursively(headNode.next);
            }
            System.out.println(headNode.data);

        }
    }



    public static void main(String[] args) {
        listNode node1=new listNode();
        listNode node2=new listNode();
        listNode node3=new listNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;

        printListReverse_recursively(node1);
    }
}
class listNode{
    int data;
    listNode next;
}
