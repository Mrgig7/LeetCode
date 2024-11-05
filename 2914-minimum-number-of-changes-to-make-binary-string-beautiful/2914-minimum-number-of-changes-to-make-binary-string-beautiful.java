class Solution {
    public int minChanges(String s) {
        int res = 0;
        for(int i = 1; i < s.length(); i+=2) {
            char f = s.charAt(i - 1);
            char sec = s.charAt(i);
            if(f != sec) res++;
        }
        return res;
    }
}