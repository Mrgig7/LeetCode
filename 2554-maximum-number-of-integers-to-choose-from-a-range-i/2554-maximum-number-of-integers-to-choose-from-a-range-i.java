class Solution {
    public int maxCount(int[] b, int n, int m) {
        int[] ba = new int[10001];
        for (int x : b) {
            ba[x] = 1;
        }
        int c = 0;
        int s = 0;
        for (int i = 1; i <= n; i++) {
            if (ba[i] == 1) continue;
            if (s + i > m) continue;
            c++;
            s += i;
        }
        return c;
    }
}