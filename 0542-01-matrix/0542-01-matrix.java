import java.util.*;
//nearest distance to 0 in a matrix
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;
         int[][] res = new int[m][n];
            Queue<int[]> q = new LinkedList<>();
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(mat[i][j] == 0){
                        q.add(new int[]{i,j});
                    }else{
                        res[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            while(!q.isEmpty()){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >=0 && r < m && c >= 0 && c < n && res[r][c] > res[curr[0]][curr[1]] + 1){
                        res[r][c] = res[curr[0]][curr[1]] + 1;
                        q.add(new int[]{r,c});
                    }
                }
            }
            return res;
    
    }
}
