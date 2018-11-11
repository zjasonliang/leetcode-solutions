import java.util.*;

public class PopulatingNextRightPointersinEachNodeII {

    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        TreeLinkNode parent = root;
        TreeLinkNode childHead = null, currentChild = null;

        while (parent != null) {
            while (parent != null) {
                if (parent.left != null) {
                    if (childHead == null) {
                        currentChild = childHead = parent.left;
                    }
                    else {
                        currentChild.next = parent.left;
                        currentChild = parent.left;
                    }
                }

                if (parent.right != null) {
                    if (childHead == null) {
                        currentChild = childHead = parent.right;
                    }
                    else {
                        currentChild.next = parent.right;
                        currentChild = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = childHead;
            childHead = currentChild = null;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        // root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);

        System.out.println(root);

        List<Integer> list = new ArrayList <>();
        list.add(1);
        list.toArray();

    }
}
