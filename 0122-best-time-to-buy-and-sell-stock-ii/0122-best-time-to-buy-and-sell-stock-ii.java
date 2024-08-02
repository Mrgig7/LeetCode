class Solution {
    public int maxProfit(int[] p) {
        int ma = 0;
        int b = p[0];
        int d = p.length;
        for(int i=1;i<d;i++) {
            if(b < p[i]) ma += p[i] - b;
            b = p[i];
        }
        return ma;
    }
}