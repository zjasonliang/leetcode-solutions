import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class PathSum {
    private boolean recur(TreeNode root, int sum) {
        if (root == null) {
            if (sum == 0) return true;
            else return false;
        }

        if (root.left == null) return recur(root.right, sum - root.val);
        if (root.right == null) return recur(root.left, sum - root.val);
        return recur(root.left, sum - root.val) || recur(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        return recur(root, sum);

    }
}
