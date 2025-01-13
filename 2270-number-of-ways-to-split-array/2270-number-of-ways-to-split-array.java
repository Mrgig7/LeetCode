class Solution {
    public int waysToSplitArray(int[] n) {
        int len = n.length;
        long c = 0;
        long t = 0;
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            t += n[i];
        }

        for (int i = 0; i < len - 1; i++) {
            c += n[i];
            if (c >= (t - c)) cnt++;
        }

        return cnt;
    }
}