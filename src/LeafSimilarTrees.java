import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {
    List<Integer> tree1 = new LinkedList<>();
    List<Integer> tree2 = new LinkedList<>();

    private void recur(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) recur(root.left, list);
        if (root.right != null) recur(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        recur(root1, tree1);
        recur(root2, tree2);

        if (tree1.size() == tree2.size()) {
            for (int i = 0; i < tree1.size(); i++)
                if (tree1.get(i) != tree2.get(i))
                    return false;
            return true;
        } else return false;
    }
}
