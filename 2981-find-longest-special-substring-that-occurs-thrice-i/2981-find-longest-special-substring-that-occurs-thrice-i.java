class Solution {
    private String s;
    private int len;

    public int maximumLength(String s) {
        this.s = s;
        this.len = s.length();

        int l = 0, r = len;

        while (l < r) {
            int m = (l + r + 1) >> 1;
            if (isSatisfied(m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l == 0 ? -1 : l;
    }

    private boolean isSatisfied(int tLen) {
        int[] f = new int[26];

        for (int i = 0; i < len;) {
            int eIdx = i + 1;
            while (eIdx < len && s.charAt(eIdx) == s.charAt(i)) {
                eIdx++;
            }

            int cIdx = s.charAt(i) - 'a';
            f[cIdx] += Math.max(0, eIdx - i - tLen + 1);

            if (f[cIdx] >= 3) {
                return true;
            }

            i = eIdx;
        }

        return false;
    }
}