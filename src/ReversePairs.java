import java.util.Arrays;
import java.util.BitSet;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int inv1 = sort(nums, left, mid);
            int inv2 = sort(nums, mid + 1, right);
            int inv3 = merge(nums, left, mid, right);
            return inv1 + inv2 + inv3;
        }
        else return 0;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // int[] leftArray = new int[leftSize];
        // int[] rightArray = new int[rightSize];

        int[] leftArray = Arrays.copyOfRange(nums, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < leftSize && j < rightSize) {
            if ((long)leftArray[i] <= ((long)rightArray[j]) * 2)
                i++;
            else {
                count += leftSize - i;
                j++;
            }
        }

        i = j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
        return count;
    }

    class BITree {
        public long[] tree;
        private int n;

        public BITree(int size) {
            this.n = size;
            this.tree = new long[n+1];
        }

        public void update(int index, int val) {
            // index = index * 2;
            while (index <= n) {
                tree[index] += val;
                index += index & (-index);
            }
        }

        public int getSum(int index) {
            int sum = 0;
            // index += 1;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public int reversePairsBIT(int[] nums) {

        TreeMap<Long, Integer> ranks = new TreeMap <>();
        for (int i : nums) {
            ranks.put((long)i, 0);
            ranks.put((long)2 * i, 0);
        }

        int rank = 1;
        for (Long i: ranks.keySet()) {
            ranks.replace(i, rank);
            rank++;
        }

        int res = 0;
        BITree biTree = new BITree(ranks.size());

        for (int i = nums.length - 1; i >= 0; i--) {
            res += biTree.getSum(ranks.get((long)nums[i]) - 1);
            biTree.update(ranks.get((long)nums[i] * 2), 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        // int [] nums = {1,3,2,3,1};
        // int [] nums = {-5, -5};
        // int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        ReversePairs s = new ReversePairs();
        System.out.println(s.reversePairsBIT(nums));
    }
}
