import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private List<Integer> res = new ArrayList<>();

    private int recur(TreeNode root, int goDown) {
        if (root == null) return 0;

        if (goDown == 0) res.add(root.val);

        int rightDepth = 0;
        int leftDepth = 0;
        rightDepth = recur(root.right, Math.max(0, goDown - 1));
        leftDepth = recur(root.left, Math.max(rightDepth, goDown - 1));

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public List<Integer> rightSideView(TreeNode root) {
        recur(root, 0);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(10);

        BinaryTreeRightSideView s = new BinaryTreeRightSideView();
        System.out.println(s.rightSideView(root));
    }
}
