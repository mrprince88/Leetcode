class Solution {
    public int coinChange(int[] den, int sum) {
        int []dp = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < den.length; j++) {
                if (den[j] <= i && dp[i - den[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - den[j]] + 1, dp[i]);
            }
        }
        return dp[sum]==Integer.MAX_VALUE ? -1: dp[sum];
    }
}
