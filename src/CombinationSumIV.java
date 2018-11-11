public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= target; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= nums.length; i++)
            for (int j = 0; j <= target; j++) {
                int c = 0;
                while (j >= c * nums[i-1]) {
                    dp[i][j] += dp[i-1][j - c*nums[i-1]];
                    c++;
                }
            }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
