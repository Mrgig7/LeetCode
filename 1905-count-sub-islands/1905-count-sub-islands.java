class Solution {
    int r = 0;
    public int countSubIslands(int[][] g1, int[][] g2) {
        int cnt = 0;
        for(int i =0;i<g2.length;i++){
            for(int j = 0;j<g2[0].length;j++){
                if(g2[i][j]==1){
                    r=1;
                    helper(g1,g2,i,j);
                    cnt+=r;
                }
            }
        }
        return cnt;
    }

    public void helper(int[][] g1, int[][] g2, int i, int j){
        if(i<0||j<0||i>=g1.length||j>=g1[0].length||g2[i][j]==0) return;
        if(g1[i][j]==0) r=0;
        g2[i][j] = 0;
        helper(g1,g2,i-1,j);
        helper(g1,g2,i+1,j);
        helper(g1,g2,i,j+1);
        helper(g1,g2,i,j-1);
    }

}