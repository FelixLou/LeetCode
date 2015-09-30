Question: https://leetcode.com/problems/bitwise-and-of-numbers-range/
```
My solution:
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for(int i = 30; i >= 0; i--){
            if(odd(m, n, 1<<i)){
                result = (result<<1) + 1;
            }
            else{
                result = result<<1;
            }
        }
        return result;
    }
    private boolean odd(int m, int n, int num){
        if(n < num) return false;
        if((n - m + 1) > num) {
            return false;
        }
        for(int i = m; i >= 0 && i <=n; i++){
            if((i/num)%2 == 0){
                return false;
            }
        }
        return true;
    }
Renjia's solution:
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
```
