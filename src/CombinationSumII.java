import java.util.*;

public class CombinationSumII {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;

    private int next(int idx) {
        int ret = idx + 1;
        while (ret < candidates.length && candidates[ret] == candidates[idx]) {
            ret++;
        }
        return ret;
    }

    private void dfs(int idx, int target, List<Integer> list) {
        if (target == 0) {
            res.add(list);
            return;
        }

        if (idx < candidates.length && target >= candidates[idx]) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[idx]);
            dfs(idx + 1, target - candidates[idx], temp);

            dfs(next(idx), target, list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target, new ArrayList<Integer>());
        return res;
    }
}
