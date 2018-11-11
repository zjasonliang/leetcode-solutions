public class SumRoottoLeafNumbers {

    public int recur(TreeNode root, int pre) {
        if (root.left != null && root.right != null)
            return recur(root.left, pre * 10 + root.val) + recur(root.right, pre * 10 + root.val);

        if (root.left != null) return recur(root.left, pre * 10 + root.val);

        if (root.right != null) return recur(root.right, pre * 10 + root.val);

        return pre * 10 + root.val;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return recur(root, 0);
    }

    public static void main(String[] args) {
        SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(s.sumNumbers(root));
    }
}

