class Solution {
    int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0 ; i < grid2.length ; i++){
            for(int j = 0 ; j < grid2[0].length ; j++){
			// applying dfs on grid2 and checking for corresponding cells in grid1 
                if(grid2[i][j] == 1){
                    ans = 1;
                    dfs(grid1, grid2, i, j);
                    count += ans;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) return ;
		// if the corresponding cell in grid1 is water, then we just make ans = 0.
        if(grid1[i][j] == 0) ans = 0;
        grid2[i][j] = 0;
        dfs(grid1, grid2, i-1, j);
        dfs(grid1, grid2, i+1, j);
        dfs(grid1, grid2, i, j+1);
        dfs(grid1, grid2, i, j-1);
    }
}