class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int j = 0, cur = 0,ma = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            ma = Math.max(ma, i + nums[i]);
            if (i == cur) {
                j++;
                cur = ma;
                if (cur >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return j;
    }
}
