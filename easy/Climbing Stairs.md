Question: https://leetcode.com/problems/climbing-stairs/
```
My solution:
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        //state
        int[] steps = new int[n];
        //initiate
        steps[0] = 1;
        steps[1] = 2;
        for(int i = 2; i < n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];
    }
///////////////////////////
Renjia's solution:
https://leetcode.com/discuss/16866/basically-its-a-fibonacci
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int oneStep = 1;
        int twoSteps = 2;
        int allSteps = 0;
        for(int i = 2; i < n; i++){
            allSteps = oneStep + twoSteps;
            oneStep = twoSteps;
            twoSteps = allSteps;
        }
        return allSteps;
    }
```
