Question: https://leetcode.com/problems/power-of-two/
```
My solution:
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        while(n%2 == 0){
            n = n/2;
        }
        return n == 1;
    }
////////////////////////////////
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return !(n&(n-1));
    }
//////////////////////////////
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
```
