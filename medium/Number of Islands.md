Question: https://leetcode.com/problems/number-of-islands/
```
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    oneToZero(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void oneToZero(char[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        oneToZero(grid, i + 1, j);
        oneToZero(grid, i, j + 1);
        oneToZero(grid, i - 1, j);   //////It's clean here!
        oneToZero(grid, i, j - 1);
    }
```
