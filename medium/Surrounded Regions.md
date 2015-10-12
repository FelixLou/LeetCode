Question: https://leetcode.com/problems/surrounded-regions/
```
    public void solve(char[][] board) {
        if(board == null || board.length ==0 || board[0].length == 0){
            return;
        }
        Queue<Point> queue = new LinkedList<Point>();
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                queue.add(new Point(i,0));
            }
            if(board[i][cols - 1] == 'O'){
                queue.add(new Point(i,cols-1));
            }
        }
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                queue.add(new Point(0,j));
            }
            if(board[rows - 1][j] == 'O'){
                queue.add(new Point(rows-1,j));
            }
        }
        while(!queue.isEmpty()){   /////////////StackOverFlow if using recursive method
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            board[row][col] = 'U';
            if(row - 1 >= 0 && board[row-1][col] == 'O'){
                queue.add(new Point(row-1,col));
            }
            if(row + 1 < rows && board[row+1][col] == 'O'){
                queue.add(new Point(row+1,col));
            }
            if(col - 1 >= 0 && board[row][col -1] == 'O'){
                queue.add(new Point(row,col-1));
            }
            if(col + 1 < cols && board[row][col + 1] == 'O'){
                queue.add(new Point(row,col+1));
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //System.out.println("ha");
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'U'){
                    board[i][j] = 'O';
                }
            }
        }
    }
  ```
