import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        int count = map.size();
        int left = 0;
        int right = 0;
        String res = "";
        int resLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right)) == 1)
                    count--;
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            while (count == 0) {
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) {
                        if (right - left + 1 < resLength) {
                            res = s.substring(left, right + 1);
                            resLength = res.length();
                        }
                        count++;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";

        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow(s, t));
    }
}
