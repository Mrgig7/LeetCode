class Solution {
    public boolean helper(char[][]board,int m,int n)
    {
        Set<Character> ch=new HashSet<>();
        for(int i=m;i<m+3;i++){
            for(int j=n;j<n+3;j++){
                if(board[i][j]=='.') continue;
                if(ch.contains(board[i][j])) return false;
                ch.add(board[i][j]);
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        Set<Character> ch=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(ch.contains(board[i][j])) return false;
                ch.add(board[i][j]);
            }
            ch.clear();
        }
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++){
                if(board[i][j]=='.') continue;
                if(ch.contains(board[i][j])) return false;
                ch.add(board[i][j]);                
            }
            ch.clear();
        }
        for(int i=0;i<=6;i+=3){
            for(int j=0;j<=6;j+=3){
                if(!helper(board,i,j))return false;
            }
        }
        return true;
        
    }
}