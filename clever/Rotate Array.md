Question: https://leetcode.com/problems/rotate-array/
```
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k > 0){
            swap(nums, 0, n - k - 1);
            swap(nums, n - k, n - 1);
            swap(nums, 0, n - 1);    
        }
    }
    private int[] swap(int[] nums, int a, int b){
        for (int i = a; i <= (a + b)/2; i++){
            int tmp = nums[i];
            nums[i] = nums[b + a - i];
            nums[b + a - i] = tmp;    
        }
        return nums;
    }
```
