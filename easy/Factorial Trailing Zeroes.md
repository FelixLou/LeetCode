Question: https://leetcode.com/problems/factorial-trailing-zeroes/
```
    public int trailingZeroes(int n) {
        int sum = 0;
        long m = 5;
        while(n >= m){
           sum += n/m; 
           m = 5*m;
        }
        return sum;
    }
////////////////////////////////////////////
Renjia's solution:
return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
```
