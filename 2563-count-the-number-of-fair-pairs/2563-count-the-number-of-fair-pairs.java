class Solution {
    public long countFairPairs(int[] nums, int l, int u) {
        Arrays.sort(nums);
        return helper(nums,u) - helper(nums,l-1);
    }
    private long helper(int[] nums, int sum){
        long res = 0;
        for(int st=0,en= nums.length-1; st < en; st++){
            while(st < en && nums[st] + nums[en] > sum)
            en--;
            res += en - st;
        }
        return res;
    }
}