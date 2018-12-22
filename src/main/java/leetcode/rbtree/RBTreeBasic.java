package leetcode.rbtree;

/**
 * 自己写的红黑树左旋、右旋和插入
 */
public class RBTreeBasic {
    RBTreeNode root;


    public void insert(int key) throws Exception{
        RBTreeNode node = new RBTreeNode(key,true,null,null,null);
        if(node != null){
            insertNode(node);
        }
    }

    public void insertNode(RBTreeNode node)throws Exception{
        RBTreeNode pre = null;
        RBTreeNode p = root;
        while(p != null){
            pre = p;
            if(node.val < p.val){
                p = p.left;
            }else{
                p = p.right;
            }
        }

        node.parent = pre;
        if(pre == null){
            root = node;
        }else{
            if(node.val < pre.val)
                pre.left = node;
            else
                pre.right = node;
        }

        fixInsert(node);
    }

    //左旋
    public void leftRotate(RBTreeNode x) throws Exception{
        RBTreeNode y =  x.right;
        x.right = y.left;
        if(y.left != null)
            y.left.parent = x;

        y.parent = x.parent;
        if(x.parent != null){
            if(x == x.parent.left)
                x.parent.left = y;
            else
                x.parent.right = y;
        }else{
            root = y;
        }

        y.left = x;
        x.parent = y;
    }

    //右旋
    public void rightRotate(RBTreeNode y)throws Exception{
        RBTreeNode x = y.left;
        y.left = x.right;
        if(x.right != null)
            x.right.parent = y;

        x.parent = y.parent;
        if(y.parent != null){
            if(y == y.parent.left)
                y.parent.left = x;
            else
                y.parent.right = x;
        }else{
            root = x;
        }

        x.right = y;
        y.parent = x;
    }


    public void fixInsert(RBTreeNode node)throws Exception{
        while(node.parent != null && node.parent.isRed){
            RBTreeNode parent = node.parent;
            RBTreeNode grandpa = parent.parent;

            if(parent == grandpa.left){
                RBTreeNode uncle = grandpa.right;
                if(uncle != null && uncle.isRed){
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandpa.isRed = true;
                    node = grandpa;
                    continue;
                }

                if(node == parent.right){
                    leftRotate(parent);
                    //node和parent交换指针
                    RBTreeNode temp = node;
                    node = parent;
                    parent = temp;
                }

                parent.isRed = false;
                grandpa.isRed = true;
                rightRotate(grandpa);
            }else{
                RBTreeNode uncle = grandpa.left;
                if(uncle != null && uncle.isRed){
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandpa.isRed = true;
                    node = grandpa;
                    continue;
                }

                if(node == parent.left){
                    rightRotate(parent);
                    //node和parent交换指针
                    RBTreeNode temp = node;
                    node = parent;
                    parent = temp;
                }

                parent.isRed = false;
                grandpa.isRed = true;
                leftRotate(grandpa);
            }
        }
        root.isRed = false;
    }

    public void print() throws Exception{
        if (root != null)
            print(root, root.val, 0);
    }

    /*
     * 打印"红黑树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print( RBTreeNode tree, int key, int direction)throws Exception {

        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d(B) is root\n", tree.val);
            else                // tree是分支节点
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.val, tree.isRed?"R":"B", key, direction==1?"right" : "left");

            print(tree.left, tree.val, -1);
            print(tree.right,tree.val,  1);
        }
    }
}

class RBTreeNode{
    public int val;
    public boolean isRed;
    public RBTreeNode left;
    public RBTreeNode right;
    public RBTreeNode parent;

    public RBTreeNode(int val,boolean isRed,RBTreeNode left,RBTreeNode right,RBTreeNode parent){
        this.val = val;
        this.isRed = isRed;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class Test{


    public static void main(String[] args) {
        int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        RBTreeBasic tree=new RBTreeBasic();

        System.out.printf("== 原始数据: ");
        for(int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        for(int i=0; i<a.length; i++) {
            try {
                tree.insert(a[i]);
            } catch (Exception e) {
               System.out.println("a[i]="+a[i]+";e="+e.getMessage());
            }
        }

        try {
            tree.print();
        } catch (Exception e1) {
            System.out.println("print："+e1.getMessage());
        }
    }
}
