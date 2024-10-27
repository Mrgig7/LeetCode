class Solution {
    public int countSquares(int[][] mat) {
        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] += Math.min(mat[i - 1][j], Math.min(mat[i][j - 1], mat[i - 1][j - 1]));
                }
            }
        }
        int res = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                res += mat[i][j];
            }
        }
        return res;
    }
}