import sun.security.util.Length;
import sun.text.resources.cldr.nd.FormatData_nd;

import javax.crypto.spec.PSource;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    private void recur(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight, TreeNode root) {
        // find the split of inorder[]
        int inSplit = inLeft;
        for (int i = inLeft; i < inRight; i++)
            if (inorder[i] == root.val) {
                inSplit = i;
                break;
            }

        // find the split of postorder[]
        int postSplit = postLeft + (inSplit - inLeft);


        // left subtree
        if (inLeft != inSplit) {
            root.left = new TreeNode(postorder[postSplit - 1]);
            recur(inorder, postorder, inLeft, inSplit, postLeft, postSplit, root.left);
        }

        // right subtree
        if (inSplit != inRight - 1) {
            root.right = new TreeNode(postorder[postRight - 2]);
            recur(inorder, postorder, inSplit + 1, inRight, postSplit, postRight - 1, root.right);
        }

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        recur(inorder, postorder, 0, inorder.length, 0, postorder.length,root);
        return root;
    }

    public static void main(String[] args) {
        // int[] inorder = {9,3,15,20,7};
        // int[] postorder = {9,15,7,20,3};

        int[] inorder = null;
        int[] postorder = null;

        ConstructBinaryTreefromInorderandPostorderTraversal s = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode root = s.buildTree(inorder, postorder);

        System.out.println(root);
    }
}
