import java.util.LinkedList;
import java.util.Queue;

public class ReverseStringII {
    private void reverse(String s, char[] chars, int begin, int end) {
        for (int i = begin; i < end; i++) {
            // begin = 10, end = 12
            // chars[11] = s.charAt(10)
            // end - 1 - (i - begin)
            chars[end - 1 - (i - begin)] = s.charAt(i);
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int round = 1;
        while (2*k*round <= s.length()) {
            reverse(s, chars, 2*k*(round-1), 2*k*(round-1) + k);
            round++;
        }

        if (2*k*(round-1) + k - 1 > s.length() - 1) {
            reverse(s, chars, 2*k*(round-1), s.length());
        } else {
            reverse(s, chars, 2*k*(round-1), 2*k*(round-1) + k);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        ReverseStringII sol = new ReverseStringII();
        System.out.println(sol.reverseStr(s, k));

    }
}
