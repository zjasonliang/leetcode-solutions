import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    private char[][] letters = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    private List<String> res = new ArrayList<>();

    private void dfs(String digits, int currentIdx, StringBuilder sb) {
        if (currentIdx > digits.length() - 1) {
            res.add(sb.toString());
            return;
        }

        for (char c : letters[digits.charAt(currentIdx) - 48]) {
            dfs(digits, currentIdx + 1, new StringBuilder(sb).append(c));
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, 0, new StringBuilder());
        return res;
    }
}
