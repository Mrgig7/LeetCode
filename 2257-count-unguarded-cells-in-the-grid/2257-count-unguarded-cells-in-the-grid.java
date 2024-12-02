class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] graph = new int[m][n];
        for (int[] guard : guards) {
            graph[guard[0]][guard[1]] = 1;
        }
        
        for (int[] wall : walls) {
            graph[wall[0]][wall[1]] = 2;
        }
        
        for (int i = 0; i < m; i++) {
            int pre = 2;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    for (int k = index+1; k < j; k++) {
                        graph[i][k] = 3;
                    }
                    pre = 1;
                    index = j;
                }
                if (graph[i][j] == 2) {
                    if (pre == 1) {
                        for (int k = index+1; k < j; k++) {
                            graph[i][k] = 3;
                        }
                    }
                    pre = 2;
                    index = j;
                }
            }
            if (pre == 1) {
                for (int k = index+1; k < n; k++) {
                    graph[i][k] = 3;
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            int pre = 2;
            int index = -1;
            for (int i = 0; i < m; i++) {
                if (graph[i][j] == 1) {
                    for (int k = index+1; k < i; k++) {
                        graph[k][j] = 3;
                    }
                    pre = 1;
                    index = i;
                }
                if (graph[i][j] == 2) {
                    if (pre == 1) {
                        for (int k = index+1; k < i; k++) {
                            graph[k][j] = 3;
                        }
                    }
                    pre = 2;
                    index = i;
                }
            }
            if (pre == 1) {
                for (int k = index+1; k < m; k++) {
                    graph[k][j] = 3;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    ans++;
                }
            } 
        }
        
        return ans;
    }
}