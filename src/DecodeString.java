import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<int[]> stack = new Stack<>();

        int current = 0;

        while (current < chars.length) {
            if (chars[current] <= '9' && chars[current] >= '0') {
                int right = current + 1;
                while (chars[right] != '[') {
                    right++;
                }

                int k = Integer.parseInt(s.substring(current, right));
                current = right + 1;
                stack.push(new int[] {sb.length(), k});
            } else if (chars[current] == ']') {
                int[] last = stack.pop();
                int left = last[0];
                int k = last[1];
                String repeat = sb.substring(left, sb.length());
                sb = sb.delete(left, sb.length());
                for (int i = 0; i < k; i++) {
                    sb.append(repeat);
                }
                current++;
            }
            else {
                sb.append(chars[current]);
                current++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
