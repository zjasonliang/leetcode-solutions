import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 1) return 0;

        int jumps = 0;
        int currentReachable = 0;

        int maxNextReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            maxNextReachable = Math.max(maxNextReachable, i + nums[i]);
            if (currentReachable == i) {
                jumps++;
                currentReachable = maxNextReachable;
            }
            if (currentReachable >= nums.length - 1) return jumps;
        }

        return jumps;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList <>();

        // int[] nums = {2,3,1,1,4};

        int [] nums = {1,2,1,1,1};

        System.out.println(jump(nums));
    }

}
