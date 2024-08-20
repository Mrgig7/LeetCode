class Solution {
      private int ma(int[] piles,int[] ss,int[][] dp,int i,int M)
    {
        int n=piles.length;
        if(i==n) return 0;
        if(2*M>=n-i) return ss[i];
        if(dp[i][M]>0) return dp[i][M];
        
        int mb=Integer.MAX_VALUE;
        for(int j=1;j<=2*M;j++){
             mb=Math.min(mb,ma(piles,ss,dp,i+j,Math.max(M,j)));
        }
        dp[i][M]=ss[i]-mb;
        return dp[i][M];
    }
    
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        if(n==1) return piles[0];
        int[] ss = new int[n];
        ss[n-1] = piles[n-1];
        for(int i=n-2;i>=0;i--){
            ss[i]=ss[i+1]+piles[i];
        }
        int[][] dp=new int[n][n+1];
        return ma(piles,ss,dp,0,1);

    }
  
}