class Solution {
    public int minSwaps(String s) {
        if (s.length() == 0) return 0;

        int sw = 0, op = 0;

        for (byte c: s.getBytes()) {
            op += '\\' - c;
            if (op < 0) {
                sw++;
                op += 2;
            }
        }

        return sw;
    }
}