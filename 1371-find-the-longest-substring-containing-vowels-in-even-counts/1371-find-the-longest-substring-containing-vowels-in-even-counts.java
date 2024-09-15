class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int ma = 0,bm = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a') bm ^= (1 << 0);
            else if(c == 'e') bm ^= (1 << 1);
            else if(c == 'i') bm ^= (1 << 2);
            else if(c == 'o') bm ^= (1 << 3);
            else if(c == 'u') bm ^= (1 << 4);
            
            if(mp.containsKey(bm)) {
                int prev = mp.get(bm);
                ma = Math.max(ma, i - prev);
            } else mp.put(bm,i);
            
        }

        return ma;
    }
}