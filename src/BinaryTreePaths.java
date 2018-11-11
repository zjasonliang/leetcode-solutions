import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> res = new ArrayList<String>();

    private void recur(TreeNode root, StringBuilder sb) {
        if (sb.length() == 0) sb.append(root.val);
        else sb.append("->" + root.val);

        if (root.left != null && root.right != null) {
            recur(root.left, new StringBuilder(sb));
            recur(root.right, sb);
            return;
        }

        if (root.left != null) {
            recur(root.left, sb);
            return;
        }

        if (root.right != null) {
            recur(root.right, sb);
            return;
        }

        res.add(sb.toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        recur(root, new StringBuilder());
        return res;
    }
}
