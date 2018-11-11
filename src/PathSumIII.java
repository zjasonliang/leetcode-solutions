public class PathSumIII {
    private int res;
    private int s;

    private void start(TreeNode root) {
        recur(root, s);

        if (root.left != null)
            start(root.left);

        if (root.right != null)
            start(root.right);
    }

    private void recur(TreeNode root, int sum) {
        if (sum == root.val) {
            res++;
        }

        if (root.left != null) {
            recur(root.left, sum - root.val);
        }

        if (root.right != null) {
            recur(root.right, sum - root.val);
        }


    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        this.s = sum;
        start(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(3);

        PathSumIII s = new PathSumIII();
        System.out.println(s.pathSum(root, 3));
    }
}
