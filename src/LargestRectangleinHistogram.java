import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                System.out.println("push " + i);
            }
            else {
                while (!stack.isEmpty() && heights[i] < stack.peek()) {
                    int idx = stack.pop();
                    System.out.println(idx);
                    int len = i - idx;
                    max = Math.max(max, len * heights[idx]);
                }
                stack.push(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        LargestRectangleinHistogram s = new LargestRectangleinHistogram();

        System.out.println(s.largestRectangleArea(heights));
    }
}
