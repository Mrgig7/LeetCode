class Solution {
    public boolean canJump(int[] nums) {
        int ma = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > ma) {
                return false; 
            }
            ma = Math.max(ma, i + nums[i]); 
        }
        return true;
    }
}
