class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return false;

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) return false;

        int target = total / k;
        Arrays.sort(nums); // Sort in descending order

        int[] groups = new int[k];
        return backtrack(groups, nums, target, 0, 0);
    }

    private boolean backtrack(int[] groups, int[] nums, int target, int idx, int currSum) {
        if (idx == nums.length) {
            for (int group : groups) {
                if (group != target) return false;
            }
            return true;
        }

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + nums[idx] <= target) {
                groups[i] += nums[idx];
                if (backtrack(groups, nums, target, idx + 1, currSum + nums[idx])) return true;
                groups[i] -= nums[idx];
            }
            if (groups[i] == 0) break; // Search Space Reduction: stop exploring if current group is empty
        }
        return false;
    }
}