class Solution {
    public boolean canJump(int[] nums) {
        int ma = 0;
        for (int i = 0; i <= ma && i < nums.length; i++) {
            ma = Math.max(ma, i + nums[i]);
            if (ma >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
