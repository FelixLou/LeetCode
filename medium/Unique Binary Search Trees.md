Question: https://leetcode.com/problems/unique-binary-search-trees/

Answer: https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
```
    public int numTrees(int n) {
        int[] number = new int[n + 1];
        number[0] = 1;
        number[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                number[i] += number[j - 1] * number[i - j]; 
            }
        }
        return number[n];
    }
```
