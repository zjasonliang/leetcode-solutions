import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int sgn = 1;
        int current = 0;  // the current value under processing

        // the values of previous strings
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                current = current * 10 + (c - '0') * sgn;
            } else if (c == '+') {
                stack.push(stack.pop() + current);
                current = 0;
                sgn = 1;
            } else if (c == '-') {
                stack.push(stack.pop() + current);
                current = 0;
                sgn = -1;
            } else if (c == '(') {
                stack.push(sgn);
                stack.push(0);
                sgn = 1;
            } else if (c == ')'){
                int temp = stack.pop() + current;
                current = stack.pop() * temp;
            }
        }


        return stack.pop() + current;
    }

    public static void main(String[] args) {
        String str = "1 + 1 + (6- 4)";
        BasicCalculator s = new BasicCalculator();
        System.out.println(s.calculate(str));
    }
}
