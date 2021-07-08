package struct;

public class TreeNodeMorris {

    private void preOrder(TreeNode root) {
        if(root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null) {
            cur2 = cur1.left;
            if(cur2 != null) {
                while(cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }

                if(cur2.right == null) { // 第一次遍历到cur1，设置从cur2回到cur1的引用
                    cur2.right = cur1;
                    System.out.print(cur1.val + "\t"); // 第一次到cur1就输出，先序遍历

                    cur1 = cur1.left; // cur1继续遍历左孩子
                }else { // 第二次遍历到cur1，证明左子树遍历完了
                    cur2.right = null;
                    cur1 = cur1.right; // cur1继续遍历右孩子
                }
            }else {
                System.out.print(cur1.val + "\t"); // cur1是叶子节点，直接输出
                cur1 = cur1.right;
            }
        }
        System.out.println();
    }


    private void inOrder(TreeNode root) {
        if(root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null) {
            cur2 = cur1.left;
            if(cur2 != null) {
                while(cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }

                if(cur2.right == null) { // 第一次遍历到cur1，设置从cur2回到cur1的引用
                    cur2.right = cur1;

                    cur1 = cur1.left; // cur1继续遍历左孩子
                }else { // 第二次遍历到cur1，证明左子树遍历完了

                    // 左子树遍历完之后输出当前节点，即中序
                    System.out.print(cur1.val + "\t");

                    cur2.right = null;
                    cur1 = cur1.right; // cur1继续遍历右孩子
                }
            }else {
                System.out.print(cur1.val + "\t"); // cur1是叶子节点，直接输出
                cur1 = cur1.right;
            }
        }
        System.out.println();
    }

    private void postOrder(TreeNode root) {
        if(root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null) {
            cur2 = cur1.left;
            if(cur2 != null) {
                while(cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }

                if(cur2.right == null) { // 第一次遍历到cur1，设置从cur2回到cur1的引用
                    cur2.right = cur1;

                    cur1 = cur1.left; // cur1继续遍历左孩子
                }else { // 第二次遍历到cur1，证明左子树遍历完了

                    cur2.right = null; // 需要先删除引用，避免影响链表翻转
                    printPostOrder(cur1.left);
                    cur1 = cur1.right; // cur1继续遍历右孩子
                }
            }else {
                cur1 = cur1.right;
            }
        }
        printPostOrder(root);
        System.out.println();
    }

    // 后续遍历有所不同，需通过将节点翻转输出，再还原节点关系，类似于链表翻转
    private void printPostOrder(TreeNode root) {
        TreeNode pre = null;
        TreeNode next = null;
        while(root != null) {
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        root = pre;
        pre = null;
        while(root != null) {
            System.out.print(root.val + "\t");
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNodeMorris traverse = new TreeNodeMorris();
        /*
        5	3	1	4	7	6	8
        1	3	4	5	6	7	8
        1	4	3	6	8	7	5
         */
//        traverse.preOrder(root);
//        traverse.inOrder(root);
        traverse.postOrder(root);
    }

}
