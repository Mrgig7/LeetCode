class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (char c : s1.toCharArray()) {
            a1[c - 'a']++;
        }

        int n = s2.length();
        int i = 0, j = 0;
        
        while (j < n) {
            a2[s2.charAt(j) - 'a']++;
            if (j - i + 1 > s1.length()) {
                a2[s2.charAt(i) - 'a']--;
                i++;
            }
            if (Arrays.equals(a1, a2)) return true;
            j++;
        }
        
        return false;
    }
}