class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int ma = Integer.MIN_VALUE;
        for (int num : nums) {
            ma = Math.max(ma, num);
        }
        int[] dis = new int[ma + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int dist = Math.abs(nums[i] - nums[j]);
                ++dis[dist];
            }
        }
        for (int dist = 0; dist <= ma; ++dist) {
            k -= dis[dist];
            if (k <= 0) {
                return dist;
            }
        }
        return -1; 
    }
}