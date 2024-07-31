class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int ma = 0;
        HashSet<Character> chSet = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (chSet.contains(s.charAt(r))) {
                chSet.remove(s.charAt(l));
                l++;
            }

            chSet.add(s.charAt(r));
            ma = Math.max(ma, r - l + 1);
        }

        return ma;       
    }
}