class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int factor = 2; factor <= n; factor++) {
            while (n % factor == 0) {
                res += factor;
                n /= factor;
            }
        }
        return res;
    }
}
