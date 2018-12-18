package offer;



public class offer39 {

    public class IsBalancedTree {
        boolean isBalance = true;

        public boolean IsBalanced_Solution(TreeNode root) {
            TreeDepth1(root);
            return isBalance;
            //isBalance 会在 TreeDepth1(root)中赋值。
        }

        public int TreeDepth1(TreeNode root) {
            if (root == null)
                return 0;
            int left = TreeDepth1(root.left);
            //左子树高度
            int right = TreeDepth1(root.right);
            //右子树高度
            if (Math.abs(left - right) > 1) {
                isBalance = false;
                //只要有一个子树的左右子树的高度绝对值大于 1 isBalance=false
            }
            return Math.max(left, right) + 1;
        }

    }
}
class TreeNode{
    public TreeNode left;
    public TreeNode right;


}
