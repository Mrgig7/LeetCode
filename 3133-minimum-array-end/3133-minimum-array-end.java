class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        for (int i = n - 1, j = 0; i > 0; i >>= 1) {
            while ((res & (1L << j)) > 0) ++j;
            res |= (i & 1L) << j;
            ++j;
        }
        return res;
    }
}