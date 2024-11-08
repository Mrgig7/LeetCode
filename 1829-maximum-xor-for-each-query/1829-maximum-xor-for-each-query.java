class Solution {
    public int[] getMaximumXor(int[] nums, int mab) {
        int n = nums.length;
        int[] a = new int[n];
        int ma = (1 << mab) - 1;

        int m = 0;
        for (int i = 0, j = n - 1; j >= 0; i++, j--) {
            m ^= nums[i];
            a[j] = ma ^ m;
        }

        return a;
    }
}