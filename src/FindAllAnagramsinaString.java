import java.util.*;

public class FindAllAnagramsinaString {
    private Map<Character, Integer> map = new HashMap<>();
    private String s;
    private String p;

    public List<Integer> findAnagrams(String s, String p) {
        this.s = s;
        this.p = p;

        List<Integer> res = new ArrayList<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();

        int left = 0;
        int right = 0;

        while (left <= s.length() - p.length() && right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) == 1)
                    count--;
                map.put(rightChar, map.get(rightChar) - 1);
                right++;
            } else {
                while (left <= right) {
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) == 1)
                            count++;
                    }
                    left++;
                }
                right++;
                left = right;
            }

            while (count == 0) {
                if (right - left == p.length())
                    res.add(left);
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) == 1)
                        count++;
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ababababab";
        String p = "aab";

        FindAllAnagramsinaString sol = new FindAllAnagramsinaString();
        System.out.println(sol.findAnagrams(s, p));
    }
}
