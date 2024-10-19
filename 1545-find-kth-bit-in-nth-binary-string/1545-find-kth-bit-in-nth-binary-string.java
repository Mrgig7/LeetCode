class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int l = (1 << n) - 1;
        if (k < l / 2 + 1)
            return findKthBit(n - 1, k);
        else if (k == l / 2 + 1)
            return '1';
        else {
            char ch = findKthBit(n - 1, l - k + 1);
            return ch == '0' ? '1' : '0';
        }
    }
}