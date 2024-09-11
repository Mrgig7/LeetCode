class Solution {
    public int minBitFlips(int start, int goal) {
        int a = (start ^ goal);
        int cnt = 0;
        while(a != 0) {
            if((a & 1) == 1) {
                cnt++;
            }
            a = a >> 1;
        }
        return cnt;
    }
}