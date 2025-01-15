class Solution {
    public int minimizeXor(int n1, int n2) {
        int b1 = getSetBits(n1);
        int b2 = getSetBits(n2);

        int res = n1;

        int fBit = (b1 > b2) ? 1 : 0;
        int fCount = Math.abs(b1 - b2);

        for (int i = 0; i <= 31; i++) {
            if (fCount == 0) {
                return res;
            }
            int cBit = (res & (1 << i)) != 0 ? 1 : 0;
            if (cBit == fBit) {
                res = res ^ (1 << i);
                fCount--;
            }
        }
        return res;
    }

    private int getSetBits(int n) {
        int sBits = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                sBits++;
            }
        }
        return sBits;
    }
}