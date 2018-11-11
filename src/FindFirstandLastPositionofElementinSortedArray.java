public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int start = 0;
        int end = nums.length - 1;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)  end = mid;
            else start = mid;
        }

        int left = 0;

        if (nums[start] == target)
            left = start;
        else if (nums[end] == target)
            left = end;
        else return new int[]{-1, -1};

        start = 0;
        end = nums.length - 1;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) start = mid;
            else end = mid;
        }

        int right = 0;

        if (nums[end] == target) right = end;
        else if (nums[start] == target) right = start;

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
}
