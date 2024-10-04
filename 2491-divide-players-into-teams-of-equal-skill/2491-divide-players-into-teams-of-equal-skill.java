class Solution {
    public long dividePlayers(int[] s) {
        if(s.length < 2) return -1;

        Arrays.sort(s);
        long c = s[0] * s[s.length - 1];
        long x = s[0] + s[s.length - 1];
        
        int i = 1, j = s.length - 2;
        while(i < j) {
            if(s[i] + s[j] != x) return -1;
            c += s[i++] * s[j--];
        }
        
        return c;
    }
}
