class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int o = 0;
        int t = s.charAt(0) == '0' ? 1 : 0;
        int sc = t;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                t += 1;
            } else {
                o++;
                t -= 1;
            }

            if (t > sc) {
                sc = t;
            }
        }
        o += (s.charAt(len - 1) == '1' ? 1 : 0);

        return o + sc;
    }
}