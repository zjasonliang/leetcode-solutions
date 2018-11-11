public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    private int recur(TreeNode root) {
        if (root == null) return 0;

        int left = recur(root.left);
        int right = recur(root.right);

        if (left > 0) {
            if (right > 0) {
                maxSum = Math.max(maxSum, left + right + root.val);
                return left > right? left + root.val : right + root.val;
            }
            else {
                maxSum = Math.max(maxSum, left + root.val);
                return left + root.val;
            }
        } else {
            if (right > 0) {
                maxSum = Math.max(maxSum, right + root.val);
                return right + root.val;
            }
            else {
                maxSum = Math.max(maxSum, root.val);
                return root.val;
            }
        }
    }

    public int maxPathSum(TreeNode root) {
        return Math.max(recur(root), maxSum);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(s.maxPathSum(root));
    }
}
