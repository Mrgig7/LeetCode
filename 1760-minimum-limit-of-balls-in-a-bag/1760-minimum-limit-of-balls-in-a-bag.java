class Solution {
    public int minimumSize(int[] nums, int maop) {
        Arrays.sort(nums);
        int l = 1, h = nums[nums.length - 1], res = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++)
                cnt = cnt + (int) Math.ceil((double) nums[i] / (double) m) - 1;
            if (cnt <= maop) {
                res = m;
                h = m - 1;
            } else
                l = m + 1;
        }
        return res;
    }
}