import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap <>();
        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);
            if (!map.containsKey(currentLetter)) {
                map.put(currentLetter, i);
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }

                start = start > map.get(currentLetter)? start: map.get(currentLetter);

                currentLength = i - start;

                map.put(currentLetter, i);
            }
        }
        return maxLength > currentLength? maxLength: currentLength;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
