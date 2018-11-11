import com.sun.org.apache.regexp.internal.REUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


public class CountofSmallerNumbersAfterSelf {
    class BITree {
        private int[] tree;
        private int n;

        public BITree(int[] input) {
            this.n = input.length;
            this.tree = new int[n+1];
            for (int i = 0; i < n; i++)
                update(i, input[i]);
        }

        public void update(int index, int val) {
            index = index + 1;
            while (index <= n) {
                tree[index] += val;
                index += index & (-index);
            }
        }

        public int getSum(int index) {
            int sum = 0;
            index += 1;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap <>();
        for (int i : nums)
            map.put(i, 0);

        int current = 1;
        for (Integer i : map.keySet()) {
            map.replace(i, current);
            current++;
        }

        int[] freq = new int[map.size() + 1];
        BITree biTree = new BITree(freq);

        // int[] res = new int[nums.length];
        List<Integer> res = new ArrayList <>();

        for (int num : nums) res.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            int rank = map.get(nums[i]);
            biTree.update(rank, 1);
            res.set(i, biTree.getSum(rank - 1));
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {};
        CountofSmallerNumbersAfterSelf s = new CountofSmallerNumbersAfterSelf();
        System.out.println(s.countSmaller(nums));
    }
}
