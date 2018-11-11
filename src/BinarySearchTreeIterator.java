public class BinarySearchTreeIterator {
    private TreeNode current;
    private TreeNode root;

    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
        this.current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (hasNext()) {
            if (current.left == null) {
                int ret = current.val;
                current = current.right;
                return ret;
            } else {
                TreeNode pred = findPred(current);
                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;
                    int ret = current.val;
                    current = current.right;
                    return ret;
                }
            }
        }
        return -1;
    }

    private TreeNode findPred(TreeNode node) {
        TreeNode current = node.left;
        while (current.right != null && current.right != node)
            current = current.right;
        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        BinarySearchTreeIterator iter = new BinarySearchTreeIterator(root);
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
    }
}
