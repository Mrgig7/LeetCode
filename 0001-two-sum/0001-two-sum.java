class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] indexedNums = new int[n][2];

        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }

        Arrays.sort(indexedNums, Comparator.comparingInt(a -> a[0]));

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int sum = indexedNums[l][0] + indexedNums[r][0];
            if (sum == target) {
                return new int[]{indexedNums[l][1], indexedNums[r][1]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
            throw new IllegalArgumentException("No two sum solution");
    }
}
