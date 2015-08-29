QUestion: https://leetcode.com/problems/largest-rectangle-in-histogram/

Link: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
```
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++){
            int curt = (height.length == i? -1: height[i]);
            while (!stack.isEmpty() && curt <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i: i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
```
