import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import javafx.scene.control.ComboBox;

import java.util.*;

public class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;

    private void dfs(List<Integer> list, int target) {
        if (target == 0) {
            res.add(list);
            return;
        }

        for (int c : candidates) {
            if (target < c) continue;

            if (list.size() == 0 || c >= list.get(list.size() - 1)) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(c);
                dfs(temp, target - c);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(new ArrayList<Integer>(), target);
        return res;
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        int[] candidates = {8,7,4,3};
        int target = 11;

        System.out.println(s.combinationSum(candidates, target));
    }
}
