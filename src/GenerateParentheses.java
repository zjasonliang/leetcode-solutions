import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private List<String> res = new ArrayList<>();
    private int n;

    private void dfs(int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }

        if (left == n) {
            dfs(left, right + 1, sb.append(')'));
            return;
        }

        if (left == right) {
            dfs(left + 1, right, sb.append('('));
            return;
        }

        dfs(left + 1, right, new StringBuilder(sb).append('('));
        dfs(left, right + 1, sb.append(')'));
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, new StringBuilder());
        return res;
    }
}
