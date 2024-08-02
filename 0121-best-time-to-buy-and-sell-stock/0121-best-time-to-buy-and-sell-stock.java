class Solution {
    public int maxProfit(int[] p) {
        int b = p[0];
        int ma = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] < b) {
                b = p[i];
            } else if (p[i] - b > ma) {
                ma = p[i] - b;
            }
        }
        return ma;
    }
}