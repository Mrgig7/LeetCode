class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            dp[i] = ((i >= zero ? dp[i - zero] : 0) + (i >= one ? dp[i - one] : 0)) % 1_000_000_007;
            if (i >= low) ans = (ans + dp[i]) % 1_000_000_007;
        }
        return ans;
    }
}