public class IncreasingOrderSearchTree {
    private TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        TreeNode ret = root;

        if (root.left != null) {
            ret = increasingBST(root.left);
            prev.right = root;
            root.left = null;
        }

        prev = root;
        root.right = increasingBST(root.right);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        IncreasingOrderSearchTree s = new IncreasingOrderSearchTree();
        System.out.println(s.increasingBST(root));
    }
}
