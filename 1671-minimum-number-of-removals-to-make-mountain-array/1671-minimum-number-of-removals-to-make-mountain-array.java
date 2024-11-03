class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] helper = new int[n], helper2 = new int[n];
        Arrays.fill(helper, 1);
        Arrays.fill(helper2, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    helper[i] = Math.max(helper[i], helper[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    helper2[i] = Math.max(helper2[i], helper2[j] + 1);
                }
            }
        }

        int ma = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (helper[i] > 1 && helper2[i] > 1) {  
                ma = Math.max(ma, helper[i] + helper2[i] - 1);
            }
        }

        return n - ma;
    }
}