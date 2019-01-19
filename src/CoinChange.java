public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++)
            dp[j] = amount + 1;

        for (int i = 1; i<= coins.length; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }

        if (dp[amount] == amount + 1)
            return -1;
        else
            return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] {2};
        int amount = 3;

        CoinChange s = new CoinChange();
        System.out.println(s.coinChange(coins, amount));
    }
}
