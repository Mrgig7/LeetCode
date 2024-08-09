class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i <= r - 3; i++) {
            for (int j = 0; j <= c - 3; j++) {
                if (Magic(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private boolean Magic(int[][] grid, int rs, int cs) {
        boolean[] chk = new boolean[10];
        for (int i = rs; i < rs + 3; i++) {
            for (int j = cs; j < cs + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || chk[num]) {
                    return false;
                }
                chk[num] = true;
            }
        }
        int s = grid[rs][cs] + grid[rs][cs + 1] + grid[rs][cs + 2];
        for (int i = rs; i < rs + 3; i++) {
            if (grid[i][cs] + grid[i][cs + 1] + grid[i][cs + 2] != s) {
                return false;
            }
        }
        for (int j = cs; j < cs + 3; j++) {
            if (grid[rs][j] + grid[rs + 1][j] + grid[rs + 2][j] != s) {
                return false;
            }
        }
        if (grid[rs][cs] + grid[rs + 1][cs + 1] + grid[rs + 2][cs + 2] != s) {
            return false;
        }
        if (grid[rs][cs + 2] + grid[rs + 1][cs + 1] + grid[rs + 2][cs] != s) {
            return false;
        }
        return true;
    }
}