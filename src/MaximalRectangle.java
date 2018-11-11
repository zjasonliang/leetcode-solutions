import sun.plugin.dom.html.ns4.NS4DOMObject;

import java.util.Stack;

public class MaximalRectangle {
    private int maxArea(int[] nums) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int idx = stack.pop();
                if (stack.isEmpty())
                    max = Math.max(max, nums[idx] * i);
                else
                    max = Math.max(max, nums[idx] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            if (stack.isEmpty())
                max = Math.max(max, nums[idx] * nums.length);
            else
                max = Math.max(max, nums[idx] * (nums.length - stack.peek() - 1));
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] nums = new int[matrix[0].length];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    nums[j] = 0;
                else
                    nums[j]++;
            }
            max = Math.max(max, maxArea(nums));
        }

        return max;
    }
}
