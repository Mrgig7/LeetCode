class Solution {
    public int longestSubarray(int[] nums) {
        int ma = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ma) {
                ma = nums[i];
            }
        }
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ma) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        res = Math.max(res,cnt);
        return res;
    }
}


