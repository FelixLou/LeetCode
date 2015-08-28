Question: https://leetcode.com/problems/triangle/
```
My solution
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        
        int size = triangle.size();
        //state
        int[][] result= new int[size][size]; 
        //initalization
        for (int i = 0; i < size; i++){
            result[size - 1][i] = triangle.get(size - 1).get(i);
        }
        //trans-function
        for (int i = size - 2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                result[i][j] = Math.min(result[i + 1][j], result[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0][0];
    }
//////////////////////////
Renjia's solution
public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}
