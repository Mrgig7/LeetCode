class Solution {
    public long maxSubarraySum(int[] nums, int k) {
          int n = nums.length;
        //   int mas = Integer.MIN_VALUE;
        long mas = Long.MIN_VALUE;
        //   int[] pre = new int[n+1];
          long[] pre = new long[n+1];

        for(int i = 0; i<n; i++) pre[i+1] = pre[i] + nums[i];
          for(int i = 0; i<n;i++){
            // for(int j = i; j <n; j++){
            //     int cur = 0;
            //     for(int l = i; l<=j;k++) cur += nums[l];
            //     int len = j - i +1;
            //     if(len%k == 0) mas = Math.max(mas, cur);
            // }
            for(int j = k; i+j<=n; j+=k){
                int l = i+j-1;
                long cur = pre[l + 1] - pre[i];
                mas = Math.max(mas, cur);
            }
          }
          return mas;
    }
}