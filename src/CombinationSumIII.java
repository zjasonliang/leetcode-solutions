import java.util.*;

public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();

    private void backtrack(int k, int n, boolean[] used, List<Integer> solution) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (n >= i && (solution.size() == 0 || (!used[i] && solution.get(solution.size() - 1) < i))) {
                used[i] = true;
                solution.add(i);
                backtrack(k - 1, n - i, used, solution);
                used[i] = false;
                solution.remove(solution.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] used = new boolean[10];
        List<Integer> solution = new ArrayList<>();
        backtrack(k, n, used, solution);
        return res;
    }
}
