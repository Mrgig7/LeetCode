class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res = new ArrayList<>();
        boolean[][] vis = new boolean[rows][cols];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        int diridx = 0;
        int r = rStart, col = cStart;
        int stps = 1;
        int celvis = 0;

        while (celvis < rows * cols) {
            for (int i = 0; i < stps; i++) {
                if (r >= 0 && r < rows && col >= 0 && col < cols && !vis[r][col]) {
                    res.add(new int[]{r, col});
                    vis[r][col] = true;
                    celvis++;
                }
                r += dir[diridx][0];
                col += dir[diridx][1];
            }
            diridx = (diridx + 1) % 4;
            if (diridx % 2 == 0) {
                stps++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
