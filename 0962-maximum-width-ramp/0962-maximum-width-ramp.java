class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length, res = 0;
        int maidx[] = new int[n];
        maidx[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            maidx[i] = Math.max(maidx[i+1],nums[i]);
        }
        int i =0, j = 1;
        while(j<n){
            if(nums[i]<=maidx[j]){
                res = Math.max(res,j-i);
                j++;
            }
            else i++;
        }
        return res;
    }
}