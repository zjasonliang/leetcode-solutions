import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
    private TreeNode recur(List<Integer> nums, int left, int right) {
        if (left == right) return null;
        int split = (left + right) / 2;
        TreeNode root = new TreeNode(nums.get(split));
        root.left = recur(nums, left, split);
        root.right = recur(nums, split + 1, right);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode current = head;
        List<Integer> nums = new ArrayList<>();

        while (current != null) {
            nums.add(current.val);
            current = current.next;
        }

        return recur(nums, 0, nums.size());
    }
}
