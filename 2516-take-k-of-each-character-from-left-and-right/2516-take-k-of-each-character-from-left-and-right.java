class Solution {
    public int takeCharacters(String s, int k) {
        int[] a = new int[3];
        
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        } 
        
        if (a[0] < k || a[1] < k || a[2] < k) {
            return -1;
        }

        int ans = a[0] + a[1] + a[2];
        int st = 0;

        for (char c : s.toCharArray()) {
            a[c - 'a']--;
            if (a[0] < k || a[1] < k || a[2] < k) {
                ans = Math.min(a[0] + a[1] + a[2] + 1, ans);
                while (s.charAt(st) != c) {
                    a[s.charAt(st) - 'a']++;
                    st++;
                }
                a[c - 'a']++;
                st++;
            }
        }

        ans = Math.min(a[0] + a[1] + a[2], ans);
        
        return ans;
    }
}