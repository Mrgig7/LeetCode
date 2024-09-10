class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set ch = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String el = "[" + board[i][j] + "]";
                    if (!ch.add(el + i) || !ch.add(j + el) || !ch.add(i/3 + el + j/3))
                        return false;
                }

            }
        }
        return true;
    }
}