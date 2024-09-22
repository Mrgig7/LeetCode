class Solution {
    public int findKthNumber(int n, int k) {
        int pre = 1;
        k--;
        while (k > 0) {
            long stp = calStp(n, pre, pre + 1);
            if (stp <= k) {
                pre++;
                k -= stp;
            } else {
                pre *= 10;
                k--;
            }
        }

        return pre;
    }
    private long calStp(int n, long curr, long next) {
        long stp = 0;
        while (curr <= n) {
            stp += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return stp;
    }
}