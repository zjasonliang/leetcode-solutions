public class PopulatingNextRightPointersinEachNode {
    private void recur(TreeLinkNode root) {
        if (root.right != null) {
            if (root.next != null)
                root.right.next = root.next.left;
            else
                root.right.next = null;
            recur(root.right);
        }

        if (root.left != null) {
            root.left.next = root.right;
            recur(root.left);
        }
    }

    public void connect(TreeLinkNode root) {
        if (root != null) {
            root.next = null;
            recur(root);
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode s = new PopulatingNextRightPointersinEachNode();

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        s.connect(root);

        System.out.println(root);
    }
}
