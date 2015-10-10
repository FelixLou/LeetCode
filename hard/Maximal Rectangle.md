Question: https://leetcode.com/problems/maximal-rectangle/
```
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        Arrays.fill(right, cols);
        int max = 0;
        for(int i = 0; i < rows; i++){
            int curLeft = 0, curRight = cols;
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                else{
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for(int j = cols - 1; j >= 0; j--){
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else{
                    right[j] = cols;
                    curRight = j;
                }
            }
            for(int j = 0; j < cols; j++){
                max = Math.max(max, (right[j] - left[j])*height[j]);
            }
        }
        return max;
    }
```
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array 
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
```
