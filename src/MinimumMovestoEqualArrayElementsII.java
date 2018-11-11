import java.util.Random;

public class MinimumMovestoEqualArrayElementsII {
    private int[] nums;

    private int diff(int [] nums, int median) {
        int ret = 0;

        for (int num : nums) {
            ret += Math.abs(num - median);
        }

        return ret;
    }

    private int quickselect(int k, int left, int right) {
        int splitIdx = partition(left, right);

        System.out.println("split: " + splitIdx);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int positionOfSplit = splitIdx - left + 1;

        if (positionOfSplit == k)
            return nums[splitIdx];

        if (positionOfSplit > k)
            return quickselect(k, left, splitIdx - 1);
        else
            return quickselect(k - positionOfSplit, splitIdx + 1, right);
    }

    private int partition(int left, int right) {
        if (left == right)
            return left;

        int pivotIdx = getRandomInRange(left, right);
        int pivotVal = nums[pivotIdx];

        swap(pivotIdx, right);

        int splitIdx = left;

        for (int i = left; i < right; i++) {
            System.out.println(nums[i]);
            if (nums[i] < pivotVal) {
                swap(i, splitIdx);
                splitIdx++;
            }
        }

        swap(right, splitIdx);
        return splitIdx;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private Random r = new Random();

    private int getRandomInRange(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    public int minMoves2(int[] nums) {
        this.nums = nums;
        // Arrays.sort(nums);

        // int median = 0;

        int median = quickselect(nums.length / 2 + 1, 0, nums.length - 1);

        // System.out.println(median);

        return diff(nums, median);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};

        MinimumMovestoEqualArrayElementsII s = new MinimumMovestoEqualArrayElementsII();

        System.out.println(s.minMoves2(nums));
    }
}
