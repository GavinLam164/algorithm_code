package struct;

import java.util.Stack;

public class TreeNodeTraverse {
    // 先序遍历
    public void preOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            // 中：输出当前节点，保持中序遍历的输出顺序
            System.out.print(root.val + "\t");
            // 右：利用栈先进后出的特性
            // 将当前节点的右孩子压入栈中由于先进后出，所以right会在中左都弹栈后，再弹栈，也就是右最后输出
            if(root.right != null) {
                stack.push(root.right);
            }
            // 左：利用栈先进后出，后进先出的特性
            // 在压入当前节点右孩子的基础上，压入左孩子，在下次弹栈时会输出该节点，满足中左顺序
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println();
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) { // 不停的向左孩子方向移动，并将沿途遍历过的节点压入栈中
                stack.push(root);
                root = root.left;
            }else { // 当移动到没有左孩子时，从栈顶取出最后一个遍历的节点，输出之后，向右孩子移动，即中序遍历：左中右
                root = stack.pop();
                System.out.print(root.val + "\t");
                root = root.right;
            }
        }
        System.out.println();
    }

    // 后续遍历
    public void postOrder(TreeNode root) {
        if (root == null) return;
        TreeNode c = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 哨兵节点，用于判断遍历的上一个节点
        // 1. 若哨兵节点不是栈顶元素的左孩子和右孩子，则证明左右两颗子树都没遍历，向左孩子移动
        // 2. 若哨兵节点是栈顶元素的左孩子，则证明左子树遍历完成，可进行右子树遍历，向右孩子移动
        // 3. 若哨兵节点是栈顶元素的右孩子或者栈顶元素没有子节点
        //    则证明左右两颗子树遍历完成，可将栈顶元素弹出输后将哨兵节点指向弹出的栈顶元素，继续遍历过程

        TreeNode p = new TreeNode(-1);

        while(!stack.isEmpty()) {
            c = stack.peek();

            if(c.left != null && p != c.left && p != c.right) { // 1
                stack.push(c.left);
            }else if(c.right != null && p != c.right) { // 2
                stack.push(c.right);
            }else { // 3
                System.out.print(stack.pop().val + "\t");
                p = c;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNodeTraverse traverse = new TreeNodeTraverse();
        traverse.preOrder(root);
        traverse.inOrder(root);
        traverse.postOrder(root);

    }
}
