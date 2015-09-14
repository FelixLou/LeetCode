Question: https://leetcode.com/problems/perfect-squares/
```
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
  ////////////////////////////
  https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
      public int numSquares(int n) {
        int m = n;
        while( m % 4 == 0 )
            m = m>>2;
        if(m % 8 == 7)
            return 4;

        int sqrtOfn = (int) Math.sqrt(n);
        if(sqrtOfn * sqrtOfn == n)//Is it a Perfect square?
            return 1;
        else{
                for(int i = 1; i <= sqrtOfn; ++i){
                    int remainder = n - i*i;
                    int sqrtOfNum = (int) Math.sqrt(remainder);
                    if(sqrtOfNum * sqrtOfNum == remainder)
                        return 2;
                }
            }
         return 3;
    }
```
