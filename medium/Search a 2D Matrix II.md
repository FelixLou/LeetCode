Question: https://leetcode.com/problems/search-a-2d-matrix-ii/
```
My solution:
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] <= target && matrix[i][cols - 1] >= target){
                for(int j = 0; j < cols; j++){
                    if(target == matrix[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
///////////////////////////////
Renjia's solution: Start from top-right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
