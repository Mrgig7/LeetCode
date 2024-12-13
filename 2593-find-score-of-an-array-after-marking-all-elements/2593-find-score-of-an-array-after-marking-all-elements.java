class Solution {
    public long findScore(int[] n) {
        int len = n.length;
        int[][] dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            dp[i][0] = n[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] m = new boolean[len];
        long res = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            if (!m[ind]) {
                res += val;

                m[ind] = true;
                if (ind > 0) m[ind - 1] = true;
                if (ind < len - 1) m[ind + 1] = true;
            }
        }

        return res;
    }
}