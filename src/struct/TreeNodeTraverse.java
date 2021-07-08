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
            System.out.print(root.val + "\t");

            if(root.right != null) {
                stack.push(root.right);
            }

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
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
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
        TreeNode p = root;
        TreeNode c = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        while(!stack.isEmpty()) {
            c = stack.peek();
            if(c.left != null && p != c.left && p != c.right) {
                stack.push(c.left);
            }else if(c.right != null && p != c.right) {
                stack.push(c.right);
            }else {
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
