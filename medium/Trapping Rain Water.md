Question: https://leetcode.com/problems/trapping-rain-water/
```
    public int trap(int[] heights) {
        // write your code here
        int sum = 0;
        if (heights == null || heights.length == 0){
            return 0;
        }
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        
        //scan from left to right
        int max = heights[0];
        for (int i = 1; i < heights.length; i++){
            if (max < heights[i]){
                max = heights[i];
            }
            leftMax[i] = max;
        }
        
        //scan from right to left
        max = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--){
            if (max < heights[i]){
                max = heights[i];
            }
            rightMax[i] = max;
        }
        
        //trap
        for (int i = 0; i < heights.length; i++){
            int trap = Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (trap > 0){
                sum += trap;
            }
        }
        return sum;
    }
```
