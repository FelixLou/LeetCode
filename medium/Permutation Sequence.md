Question: https://leetcode.com/problems/permutation-sequence/
```
    public String getPermutation(int n, int k) {
        if (factorial(n) < k){
            return "";
        }
        String result = "";
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++){
            num.add(i);
        }
 
        for (int i = n; i > 0; i--){
            int sum = factorial(i - 1);
            int kth = (int) Math.ceil(k / (double) sum);          ////     get新技能！
            result += num.get(kth);
            num.remove(kth);                                    ///get 新技能！
            k = k %sum;
            if(k == 0) k = sum;
        }
        return result;
    }
    
    private int factorial(int n){
        int result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
```
