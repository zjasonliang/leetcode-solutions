import java.util.PriorityQueue;

public class ConvertSortedArraytoBinarySearchTree {
    private TreeNode recur(int[] nums, int left, int right) {
        if (left == right) return null;
        int split = (left + right) / 2;
        TreeNode root = new TreeNode(nums[split]);
        root.left = recur(nums, left, split);
        root.right = recur(nums, split + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return recur(nums, 0, nums.length);
    }
}
