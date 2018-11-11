import java.time.YearMonth;

public class FlattenBinaryTreetoLinkedList {
    private TreeNode recur(TreeNode root) {
        if (root.left == null && root.right == null) return root;

        if (root.left != null && root.right != null) {
            TreeNode lTail = recur(root.left);
            TreeNode rTail = recur(root.right);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            lTail.right = temp;
            return rTail;
        }

        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            return recur(root.right);
        }

        return recur(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        recur(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(5);
        // root.right.right = new TreeNode(6);

        FlattenBinaryTreetoLinkedList s = new FlattenBinaryTreetoLinkedList();
        s.flatten(root);

        System.out.println(root);
    }
}
