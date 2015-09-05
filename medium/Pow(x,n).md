Question: https://leetcode.com/problems/powx-n/
```
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        System.out.println(n);
        if(n<0){
            if (n == Integer.MIN_VALUE){
            	
                return myPow(x*x, n/2);
            }
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
    ///////////////////
        public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        for (double f = x; n > 0; n = n >> 1) {
            if (n % 2 == 1) {
                result *= f;
            }
            f = f * f;
        }
        return result;
    }
```
