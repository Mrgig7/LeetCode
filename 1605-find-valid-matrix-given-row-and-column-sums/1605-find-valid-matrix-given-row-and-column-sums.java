class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowSum[i] == 0 || colSum[j] == 0) {
                    matrix[i][j] = 0;
                    continue;
                }
                
                int min = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
                sum += min;
            }
        }
        

        
        return matrix;
    }
}