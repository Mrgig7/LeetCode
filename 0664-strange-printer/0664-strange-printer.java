class Solution {

public int strangePrinter(String s) {
    if (s.equals("")) return 0;
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++)
        dp[i][i] = 1;
    for (int l = 2; l <= n; l++) {
        for (int i = 0; i < n && l + i - 1 < n; i++) {
            int j = l + i - 1;
            dp[i][j] = dp[i][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            for (int k = i + 1; k < j; k++) {
                if (s.charAt(k) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j - 1]);
                }
            }
        }
    }
    return dp[0][n - 1];
}
}