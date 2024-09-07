class Solution {
    public int findNthDigit(int n) {
        int d = 1,st = 1;
        long cnt = 9;
        
        while (n > d * cnt) {
            n -= d * cnt;
            d++;
            cnt *= 10;
            st *= 10;
        }
        
        st += (n - 1) / d;
        String s = Integer.toString(st);
        return Character.getNumericValue(s.charAt((n - 1) % d));
    }
}