Question: https://leetcode.com/problems/game-of-life/
```
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        int[][] dir ={{1,-1},{1,1},{1,0},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}}; //
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int live = 0;
                for(int[] d:dir){
                    if(d[0] + i >= rows || d[0] + i<0 || d[1]+j>=cols ||d[1]+j<0){
                        continue;
                    }
                    if(board[d[0]+i][d[1]+j] == 1 || board[d[0]+i][d[1]+j] == 2){
                        live++;
                    } 
                }
                if(board[i][j] == 0 && live == 3) board[i][j] = 3;
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2; // 先用别的值替代，然后再换回来！新技能GET!
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] %= 2;
            }
        }
    }
```
