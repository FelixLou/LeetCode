Question: https://leetcode.com/problems/word-search/
```
My solution:
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        int len = word.length();
        if(rows * cols < len) return false;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int start = 0;
                if(board[i][j] == word.charAt(start)){
                    char tmp = board[i][j];
                    board[i][j] = '0';
                    if(isExist(board,i,j,word,1)){
                        return true;
                   }
                   board[i][j] = tmp;
                }
            }
        }       
        return false;
    }
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean isExist(char[][] board, int i, int j, String word, int index){
        if(index >= word.length()){
            return true;
        }
         for(int[] d:dir){
            if(d[0] + i >= board.length || d[0] + i < 0|| d[1] + j >= board[0].length || d[1]+j<0) continue;
            if(board[i+d[0]][j+d[1]] == word.charAt(index)){
                char tmp = board[i + d[0]][j +d[1]];
                board[i + d[0]][j +d[1]] = '0';
                if(isExist(board, i + d[0], j+d[1], word, index + 1)){
                    return true;
                }
                board[i + d[0]][j +d[1]] = tmp;
            }
         }
         return false;
         
    }
}
////////////////////////////////////////////
Renjia's solution:
public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; i++)
        for(int j = 0; j < board[0].length; j++){
            if(exist(board, i, j, word, 0))
                return true;
        }
    return false;
}
private boolean exist(char[][] board, int i, int j, String word, int ind){
    if(ind == word.length()) return true;
    if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
        return false;
    board[i][j]='*';
    boolean result =    exist(board, i-1, j, word, ind+1) ||
                        exist(board, i, j-1, word, ind+1) ||
                        exist(board, i, j+1, word, ind+1) ||
                        exist(board, i+1, j, word, ind+1);
    board[i][j] = word.charAt(ind);
    return result;
}
```
