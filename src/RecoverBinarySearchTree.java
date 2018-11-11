import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

    private TreeNode first, second;

    private TreeNode prev;

    private void recur(TreeNode root) {
        if (root != null) {
            recur(root.left);
            if (prev != null && prev.val > root.val) {
                if (first == null)
                    first = prev;
                second = root;
            }
            prev = root;
            recur(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        recur(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // TreeNode root = new TreeNode(0);
        // root.left = new TreeNode(1);

        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        s.recoverTree(root);

        System.out.println(root);
    }
}
