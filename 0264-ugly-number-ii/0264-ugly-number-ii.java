class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        
        int[] u = new int[n];
        u[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        
        for (int i = 1; i < n; i++) {
            int nu = Math.min(n2, Math.min(n3, n5));
            u[i] = nu;
            if (nu == n2) {
                i2++;
                n2 = u[i2] * 2;
            }
            if (nu == n3) {
                i3++;
                n3 = u[i3] * 3;
            }
            if (nu == n5) {
                i5++;
                n5 = u[i5] * 5;
            }
        }
        
        return u[n - 1];
    }
}
