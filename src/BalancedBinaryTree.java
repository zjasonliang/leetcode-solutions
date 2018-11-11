public class BalancedBinaryTree {
    private int depth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (-2 < leftDepth - rightDepth && leftDepth - rightDepth < 2)
            return 1 + Math.max(leftDepth, rightDepth);
        else throw new IllegalArgumentException();
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        try {
            if (-2 < depth(root.left) - depth(root.right) && depth(root.left) - depth(root.right) < 2) return true;
            else return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(3);

        BalancedBinaryTree s = new BalancedBinaryTree();

        System.out.println(s.isBalanced(root));
    }
}
