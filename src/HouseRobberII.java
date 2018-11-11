public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[][] dp = new int[nums.length][2];

        dp[0][1] = nums[0];
        dp[0][0] = 0;

        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < dp.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
        }

        dp[dp.length - 1][1] = dp[dp.length - 2][1];
        dp[dp.length - 1][0] = Math.max(dp[dp.length - 3][0] + nums[dp.length - 1], dp[dp.length - 2][0]);
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,7,5,3,1};

        HouseRobberII s = new HouseRobberII();

        System.out.println(s.rob(nums));
    }
}
