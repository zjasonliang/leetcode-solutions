import java.util.*;

public class SerializeandDeserializeBST {
    void preorder(StringBuilder sb, TreeNode root) {
        if (root == null)
            return;

        sb.append(root.val);
        sb.append(' ');
        preorder(sb, root.left);
        preorder(sb, root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(sb, root);

        return sb.toString();
    }

    TreeNode buildBST(Queue<Integer> nodes, int minVal, int maxVal) {
        if (!nodes.isEmpty() && minVal < nodes.peek() && nodes.peek() < maxVal) {
            int currentVal = nodes.poll();
            TreeNode node = new TreeNode(currentVal);
            node.left = buildBST(nodes, minVal, currentVal);
            node.right = buildBST(nodes, currentVal, maxVal);
            return node;
        } else {
            return null;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // Stack<Integer> stack = new Stack<>();

        Queue<Integer> queue = new LinkedList <>();

        for (String s : data.trim().split(" ")) {
            System.out.println(s);
            queue.add(Integer.parseInt(s));
        }


        // for (int n : nodes)
        //     stack.push(n);

        return buildBST(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        SerializeandDeserializeBST s = new SerializeandDeserializeBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);

        s.deserialize(s.serialize(root));
    }
}
