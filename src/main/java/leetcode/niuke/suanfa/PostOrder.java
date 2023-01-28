package leetcode.niuke.suanfa;

import java.util.Stack;

/**
 * @Author: zengqx
 * @Date: 2022/11/29 11:59
 */
public class PostOrder {
    public static int[] postorderTraversal(TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        int len = output.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {

            TreeNode temp = output.pop();
            arr[i] = temp.val;
            System.out.println(temp.val);
        }
        return arr;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        postorderTraversal(root);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
