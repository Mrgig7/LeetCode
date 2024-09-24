import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return true;
        if (n < k) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        int subsetSum = sum / k;
        Arrays.sort(nums); // Sort in ascending order
        reverseArray(nums); // Reverse to get descending order

        // Early pruning: Check if any number exceeds subsetSum
        for (int num : nums) {
            if (num > subsetSum) return false;
        }

        boolean[] taken = new boolean[n];
        Map<String, Boolean> memo = new HashMap<>();

        return helper(nums, taken, subsetSum, k, 0, 0, memo);
    }

    private boolean helper(int[] nums, boolean[] taken, int subsetSum, int k, int curIdx, int currentSum, Map<String, Boolean> memo) {
        if (curIdx == k) return true;

        String key = Arrays.toString(taken) + curIdx + currentSum;
        if (memo.containsKey(key)) return memo.get(key);

        if (currentSum == subsetSum) {
            boolean result = helper(nums, taken, subsetSum, k, curIdx + 1, 0, memo);
            memo.put(key, result);
            return result;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!taken[i] && currentSum + nums[i] <= subsetSum) {
                taken[i] = true;
                boolean next = helper(nums, taken, subsetSum, k, curIdx, currentSum + nums[i], memo);

                taken[i] = false;
                if (next) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

        memo.put(key, false);
        return false;
    }

    private void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}