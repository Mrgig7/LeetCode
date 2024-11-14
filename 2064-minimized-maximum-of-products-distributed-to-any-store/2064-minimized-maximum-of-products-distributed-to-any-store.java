class Solution {
    public boolean func(int n, int[] q, int m) {
        for (int x : q) {
            n -= (x + m - 1) / m;
            if (n < 0) return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] q) {
        int l = 1, r = 100000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (func(n, q, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}