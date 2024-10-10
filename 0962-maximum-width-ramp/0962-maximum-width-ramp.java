class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));
        int ma = 0;
        int midx = idx[0];
        
        for (int i = 1; i < n; i++) {
            midx = Math.min(midx, idx[i]);
            ma = Math.max(ma, idx[i] - midx);
        }
        return ma;
    }
}