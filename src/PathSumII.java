import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private List <List <Integer>> res = new ArrayList <>();

    private void recur(TreeNode root, int sum, List <Integer> path) {
        if (root == null) {
            if (sum == 0)
                res.add(path);
        } else {
            path.add(root.val);

            if (root.left == null) recur(root.right, sum - root.val, path);
            else if (root.right == null) recur(root.left, sum - root.val, path);
            else {
                recur(root.left, sum - root.val, new ArrayList <>(path));
                recur(root.right, sum - root.val, new ArrayList <>(path));
            }
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        recur(root, sum, new ArrayList <>());
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumII s = new PathSumII();
        System.out.println(s.pathSum(root, 22));
    }
}
