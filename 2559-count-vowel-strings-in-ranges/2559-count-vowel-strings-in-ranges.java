class Solution {
    public boolean isV(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public boolean checker(String s) {
        return isV(s.charAt(0)) && isV(s.charAt(s.length() - 1));
    }

    public int[] vowelStrings(String[] w, int[][] q) {
        int n = w.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = checker(w[i]) ? p[i] + 1 : p[i];
        }
        int[] r = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int rIdx = q[i][1];
            r[i] = p[rIdx + 1] - p[l];
        }
        return r;
    }
}