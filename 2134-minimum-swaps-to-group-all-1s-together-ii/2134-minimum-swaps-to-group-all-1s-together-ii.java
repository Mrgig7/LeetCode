class Solution {
    public int minSwaps(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t += num;
        }
        int n = nums.length;
        if (t == 0) {
            return 0;
        }
        int[] nums2 = new int[n * 2];
        System.arraycopy(nums, 0, nums2, 0, n);
        System.arraycopy(nums, 0, nums2, n, n);
        int s = 0;
        for (int i = 0; i < t; i++) {
            s += nums2[i];
        }
        int ma = s;
        int res = t - ma;
        
        for (int i = 1; i < n; i++) {
            s += nums2[i + t - 1] - nums2[i - 1];
            ma = Math.max(ma, s);
            res = Math.min(res, t - ma);
        }
        
        return res;
    }
}