class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }
        int m = q.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = q[i][0];
            int y = q[i][1];
            if (x == 0) {
                res[i] = pre[y];
            } else {
                res[i] = pre[y] ^ pre[x - 1];
            }
        }
        return res;
    }
}