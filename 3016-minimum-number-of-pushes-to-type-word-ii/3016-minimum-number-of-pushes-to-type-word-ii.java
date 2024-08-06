

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        
        int p = 0;
        int t = 1;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; 

            p += freq[i] * t;
            if ((25 - i) % 8 == 7) {
                t++;
            }
        }

        return p;
    }
}
