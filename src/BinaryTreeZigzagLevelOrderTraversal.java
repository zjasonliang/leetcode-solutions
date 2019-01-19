import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        q.add(root);
        levels.add(-1);

        LinkedList temp = new LinkedList<>();

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            int level = levels.poll();

            if (res.size() == level) {
                if (level != -1)
                    res.add(temp);

                temp = new LinkedList<>();
            }

            if (level % 2 == 0)
                temp.addFirst(current.val);
            else
                temp.addLast(current.val);

            if (current.left != null) {
                q.add(current.left);
                levels.add(level + 1);
            }

            if (current.right != null) {
                q.add(current.right);
                levels.add(level + 1);
            }
        }

        res.add(temp);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(s.zigzagLevelOrder(root));
    }
}
