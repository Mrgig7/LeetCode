class Solution {
    public int maxProfit(int[] pri) {
        
        int n = pri.length;
        int [][][]dp = new int [n][2][3];
        for(int [][] i: dp){
            for(int [] j : i){
                Arrays.fill(j,-1);
            }
        }
        return helper(0,n,0,2,pri,dp);
    }
    int helper(int idx, int n, int buy, int tran, int [] pri, int [][][]dp){

        if(idx==n|| tran==0) return 0;
        if(dp[idx][buy][tran]!=-1) return dp[idx][buy][tran];

        int pf =0;
        if(buy ==0){
            pf = Math.max(0+ helper(idx+1,n,0,tran,pri,dp),
            -pri[idx]+helper(idx+1,n,1,tran,pri,dp));
        }
        if(buy==1){
            pf = Math.max(0+helper(idx+1,n,1,tran,pri,dp),
            pri[idx] + helper(idx+1,n,0,tran-1,pri,dp));
        }
        return dp[idx][buy][tran] = pf;
    }
}