Question: https://leetcode.com/problems/spiral-matrix/
```
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
	        return result;
	    }
		int row = 0;
		int col = 0;
		int rows = matrix.length - 1;
		int cols = matrix[0].length - 1;
		boolean[] visitedRows = new boolean[rows + 1];
		boolean[] visitedCols = new boolean[cols + 1];
		int i = 0;
		int j = 0;
		int count = 1;
		int num = (rows + 1) * (cols + 1);
		result.add(matrix[i][j]);
		while (count < num) {
			
            // right
			while (!visitedRows[i] && j < cols) {
			    j++;
				result.add(matrix[i][j]);
				count++;
				if (j == cols){
				    row++;
				    visitedRows[i] = true;
				}
			}
		//	System.out.println("right" + count);
			// down
			while (!visitedCols[j] && i < rows) {
			    i++;
				result.add(matrix[i][j]);
				count++;
				if (i == rows){
				    cols--;
				    visitedCols[j] = true;
				}
			}
		//	System.out.println("down"+count);
			// left
			while (!visitedRows[i] && j > col) {
			    j--;
				result.add(matrix[i][j]);
				count++;
				if (j == col){
				    rows--;
				    visitedRows[i] = true;
				}
			}
		//	System.out.println("left"+count);
			// up
			while (!visitedCols[j] && i > row) {
			    i--;
				result.add(matrix[i][j]);
				count++;
				if (i == row){
				    col++;
				    visitedCols[j] = true;
				}
			}
		//	System.out.println("up"+count);
		}
		return result;

	}
////////////////////////////////////
  public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
```
