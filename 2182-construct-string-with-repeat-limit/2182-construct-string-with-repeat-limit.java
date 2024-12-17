class Solution {
    public static String repeatLimitedString(String s, int r) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        
        char[] st = new char[s.length()];
        int wd = 0;
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < c[i]; j++) {
                st[wd++] = (char) (i + 'a');
            }
        }

        int rp = 0;
        char cu = st[0];
        int nx = 1;
        
        for (int i = 0; i < st.length; i++) {
            if (st[i] == cu) {
                rp++;
                if (rp == r + 1) {
                    if (nx < i) nx = i + 1;
                    while (nx < st.length && st[nx] >= cu) nx++;
                    if (nx == st.length) return String.valueOf(st, 0, i);
                    
                    char tmp = st[i];
                    st[i] = st[nx];
                    st[nx] = tmp;

                    rp = 0;
                }

            }
            else {
                cu = st[i];
                rp = 1;
            }
        }

        return String.valueOf(st);
    }
}