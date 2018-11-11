import com.sun.javadoc.ThrowsTag;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private int findMax(TreeNode root) {
         if (root.right == null) return root.val;
         else return findMax(root.right);
    }

    private int findMin(TreeNode root) {
         if (root.left == null) return root.val;
         else return findMin(root.left);
    }

    private void recur(List<Integer> res, TreeNode root) {
         if (root != null) {
             recur(res, root.left);
             res.add(root.val);
             recur(res, root.right);
         }
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        List<Integer> res = new ArrayList <>();

        if (root.left != null) recur(res, root.left);
        res.add(root.val);
        if (root.right != null) recur(res, root.right);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1))
                return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left) || !isValidBST(root.right))
            return false;
        else {
            if (root.left != null && findMax(root.left) >= root.val)
                return false;
            if (root.right != null && findMin(root.right) <= root.val)
                return false;
        }

        return true;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        System.out.println(s.isValidBST2(root));
    }
}
