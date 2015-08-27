Question: https://leetcode.com/problems/rotate-image/
```
//先上下翻转再横纵对调即可完成旋转；或先横纵对调在左右翻转
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int tmp = 0;
        for (int i = 0; i < m/2; i++){
            for (int j = 0; j < n; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = tmp;
            }
        }
        
        for (int i = 0; i < m; i++){
            for (int j = i; j < n; j++){              //get新技能 对角反转
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
```
