class Solution {
    public String compressedString(String word) {
        char[] sa = word.toCharArray();
        StringBuilder s = new StringBuilder();
        int i = 0, n = sa.length, j;
        while (i < n) {
            for (j = 1; i + j < n && j < 9; ++j) {
                if (sa[i + j] != sa[i]) {
                    break;
                }
            }
            s.append((char)('0' + j)).append(sa[i]);
            i = i + j;
        }
        return s.toString();
    }
}