class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] chk = new boolean[s.length() + 1][p.length() + 1];

        chk[0][0] = true;

        for (int i = 1; i < chk[0].length; i++) {
            if (p.charAt(i - 1) == '*') chk[0][i] = chk[0][i - 2];
        }

        for (int i = 1; i < chk.length; i++) {
            for (int j = 1; j < chk[0].length; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    chk[i][j] = chk[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    chk[i][j] = chk[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        chk[i][j] = chk[i][j] | chk[i - 1][j];
                    }
                } else {
                    chk[i][j] = false;
                }
            }
        }

        return chk[s.length()][p.length()];
    }
}