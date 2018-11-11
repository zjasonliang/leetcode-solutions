public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && recur(a.left, b.right) && recur(a.right, b.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
}
