class Solution {
    public String shortestPalindrome(String s) {
        String re = new StringBuilder(s).reverse().toString();
        String ns = s + "#" + re;
        int[] hlp = new int[ns.length()];
        for (int i = 1, j = 0; i < ns.length(); ++i) {
            j = hlp[i - 1];
            while (j > 0 && ns.charAt(i) != ns.charAt(j)) j = hlp[j - 1];
            if (ns.charAt(i) == ns.charAt(j)) ++j;
            hlp[i] = j;
        }
        return re.substring(0, s.length() - hlp[hlp.length - 1]) + s;
    }
}