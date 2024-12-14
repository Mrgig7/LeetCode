class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min <= 2) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}