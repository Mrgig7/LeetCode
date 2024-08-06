import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    int[] columns;
    Map<Integer, String> map = new HashMap<>();
    
    public List<List<String>> solveNQueens(int n) {
        columns = new int[n];
        char[] c = new char[n];
        Arrays.fill(c, '.');
        for (int i = 0; i < n; i++) {
            c[i] = 'Q';
            map.put(i, new String(c));
            c[i] = '.';
        }
        dfs(n, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int n, int row, int col1, int di1, int di2) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                t.add(map.get(columns[i]));
            }
            res.add(t);
            return;
        }
        int ap = ((1 << n) - 1) & (~(col1 | di1 | di2));
        while (ap != 0) {
            int pos = ap & (-ap);
            ap = ap & (ap - 1);
            int col = Integer.bitCount(pos - 1);
            columns[row] = col;
            dfs(n, row + 1, col1 | pos, (di1 | pos) << 1, (di2 | pos) >> 1);
        }
    }
}
