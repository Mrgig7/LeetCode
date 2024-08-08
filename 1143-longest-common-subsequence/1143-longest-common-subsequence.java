class Solution {
    public static int longestCommonSubsequence(String t1, String t2) {
        int m=t1.length();
        int n=t2.length();
        int[][] d = new int[m + 1][n + 1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (t1.charAt(i-1) == t2.charAt(j-1)) {
                    d[i][j]=d[i-1][j-1]+1;
                } else {
                    d[i][j]=Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }
        return d[m][n];

    }
}