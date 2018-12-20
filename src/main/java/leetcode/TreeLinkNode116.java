package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkNode116 {

    public static void main(String[] args){
        TreeLinkNode rootLeft = new TreeLinkNode(2);
        TreeLinkNode rootRight = new TreeLinkNode(3);
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = rootLeft;
        root.right = rootRight;

        connect(root);
    }

    public static void connect(TreeLinkNode root) {
        if(root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(queue.size() > 0){
            int tempSize = queue.size();
            for(int i = 0;i<tempSize;i++){
                TreeLinkNode tempNode =  queue.poll();
                if(i+1 < tempSize)
                    tempNode.next = queue.peek();
                else
                    tempNode.next = null;

                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
        }
    }
}


class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }