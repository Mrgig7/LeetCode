class Solution {
    public int maxMoves(int[][] grid) {
        int mv = 0;
        int n= grid.length;
        int m= grid[0].length;

        int [][] memo = new int[n][m]; 

        for(int j= 0; j< m; j++) {
            for(int i= 0; i< n; i++) {
                if(j!= 0 && memo[i][j]== 0) continue;

                if((j+1) < m) {
                    if((i-1) >= 0 && grid[i-1][j+1]> grid[i][j]) {
                        memo[i-1][j+1]= Math.max(memo[i-1][j+1], 1 + memo[i][j]);
                        mv = Math.max(mv, memo[i-1][j+1]);
                    } 
                    
                    if((i) < n && grid[i][j+1]> grid[i][j]) {
                        memo[i][j+1]= Math.max(memo[i][j+1], 1 + memo[i][j]);
                        mv = Math.max(mv, memo[i][j+1]);
                    } 
                    
                    if((i+1) < n && grid[i+1][j+1]> grid[i][j]) {
                        memo[i+1][j+1]= Math.max(memo[i+1][j+1], 1 + memo[i][j]);
                        mv = Math.max(mv, memo[i+1][j+1]);
                    }
                }
            }
        }
        return mv;
    }
}