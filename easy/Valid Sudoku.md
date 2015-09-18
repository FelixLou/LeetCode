Question: https://leetcode.com/problems/valid-sudoku/
```
My solution: Not O-O!!!!
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        for(int i = 0; i < size; i++){
            HashMap<Character, Integer> mapRow = new HashMap<Character, Integer>();
            HashMap<Character, Integer> mapCol = new HashMap<Character, Integer>();
            for(int j = 0; j < size; j++){
                if(board[i][j] != '.'){
                    if(mapRow.containsKey(board[i][j])){
                        return false;
                    }
                    else{
                        mapRow.put(board[i][j], 1);
                    }
                }
                if(board[j][i] != '.'){
                    if(mapCol.containsKey(board[j][i])){
                        return false;
                    }
                    else{
                        mapCol.put(board[j][i], 1);
                    }
                }

            }
            mapCol.clear();
            mapRow.clear();
        }
        for(int i = 0; i < size; i = i + 3){
            for(int j = 0; j < size; j = j + 3){
                HashMap<Character, Integer> mapNine = new HashMap<Character, Integer>();
                for(int k = i; k < i + 3; k++){
                    for(int m = j; m < j + 3; m++){
                        if(board[k][m] != '.'){
                            if(mapNine.containsKey(board[k][m])){
                                return false;
                            }
                            else{
                                mapNine.put(board[k][m], 1);
                            }
                        }
                    }
                }
                mapNine.clear();
            }
        }
        return true;
    }
///////////////////////////////////
Renjia's solution:
public boolean isValidSudoku(char[][] board) {
    for (int i=0; i<9; i++) {
        if (!isParticallyValid(board,i,0,i,8)) return false;
        if (!isParticallyValid(board,0,i,8,i)) return false;
    }
    for (int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
        }
    }
    return true;
}
private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
    Set singleSet = new HashSet();
    for (int i= x1; i<=x2; i++){
        for (int j=y1;j<=y2; j++){
            if (board[i][j]!='.') if(!singleSet.add(board[i][j])) return false;
        }
    }
    return true;
}
```
