Question: https://leetcode.com/problems/jump-game-ii/
```
My solution:
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = -1;
            for (int j = 0; j < i; j++) {
                if (steps[j] != -1 && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        
        return steps[A.length - 1];
    }
////////////////////////////////////////
Renjia's solution:
//This solution cannot hold the situation that the man cannot jump to the end!
public int jump(int[] A) {
    int steps = 0;
    int reach = 0;
    int max = 0;
    for(int i=0; i<A.length-1; i++) {
        if(i > reach){
            return Integer.MAX_VALUE;
        }
        max = Math.max(max, i+A[i]);
        if( i == reach ) {
            steps++;
            reach = max;
        } 
    }
    return steps;
}
```
