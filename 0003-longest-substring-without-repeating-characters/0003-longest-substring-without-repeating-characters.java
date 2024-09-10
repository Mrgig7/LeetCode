
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        boolean[] chk = new boolean[256];
        int n = 0, l = 0;
        for (int i = 0; i < ch.length; i++) {
            while (chk[ch[i]]) {
                chk[ch[l]] = false;
                l++;
            }
            chk[ch[i]] = true;
            n = Math.max(n, i - l + 1);
        }
        return n;
    }
}