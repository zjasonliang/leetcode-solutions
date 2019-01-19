import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    boolean[] used;

    private void recur(int current, List<Integer> list) {
        if (current == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                list.add(nums[i]);
                recur(current + 1, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];

        Arrays.sort(nums);

        recur(0, new ArrayList<Integer>());

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        PermutationsII s = new PermutationsII();

        System.out.println(s.permuteUnique(nums));
    }
}
