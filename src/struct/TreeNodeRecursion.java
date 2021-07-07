package struct;

public class TreeNodeRecursion {
    // 先序遍历，先输出当前节点，再递归左子树、后递归右子树
    public void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历，先递归左子树，左子树处理完成后输出当前节点，再递归右子树
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // 后续遍历，先递归左子树、右子树，最后输出当前节点
    public void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
