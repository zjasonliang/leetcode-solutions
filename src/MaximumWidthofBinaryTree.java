import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumWidthofBinaryTree {
    class Pair {
        int leftmost;
        int rightmost;
        Pair (int l, int r) {
            leftmost = l;
            rightmost = r;
        }
    }

    private Map<Integer, Pair> map = new HashMap<>();

    private int getLeft(int node) {
        return node * 2 + 1;
    }

    private int getRight(int node) {
        return node * 2 + 2;
    }

    private void recur(TreeNode root, int level, int idx) {
        if (root == null) return;

        if (map.containsKey(level)) {
            map.get(level).leftmost = Math.min(map.get(level).leftmost, idx);
            map.get(level).rightmost = Math.max(map.get(level).rightmost, idx);
        } else {
            map.put(level, new Pair(idx, idx));
        }

        recur(root.left, level + 1, getLeft(idx));
        recur(root.right, level + 1, getRight(idx));
    }

    public int widthOfBinaryTree(TreeNode root) {
        recur(root, 0, 0);

        int max = 0;

        for (int level : map.keySet()) {
            max = Math.max(max, map.get(level).rightmost - map.get(level).leftmost + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        MaximumWidthofBinaryTree s = new MaximumWidthofBinaryTree();

        System.out.println(s.widthOfBinaryTree(root));
    }
}
