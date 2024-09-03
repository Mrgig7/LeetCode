class Solution {
    public int getLucky(String s, int k) {
        int si = 0;
        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            while (val > 0) {
                si += val % 10;
                val /= 10;
            }
        }
        
        while (--k > 0) {
            int ns = 0;
            while (si > 0) {
                ns += si % 10;
                si /= 10;
            }
            si = ns;
        }
        
        return si;
    }
}