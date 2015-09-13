Question: https://leetcode.com/problems/house-robber/
```
My solution:
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //state
        int[] money = new int[nums.length];
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[1], nums[0] + nums[2]);
        //initiate
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        money[2] = Math.max(nums[1], nums[0] + nums[2]);
        for(int i = 3; i < nums.length; i++){
            money[i] = Math.max(Math.max(money[i - 2], money[i - 3]) + nums[i], money[i - 1]);
        }
        return money[nums.length - 1];
    }
///////////////////////////////////////
被爆成渣了好吗
Renjia's solution:
    public int rob(int[] num) {
        int last = 0;
        int now = 0;
        int tmp;
        for (int n :num) {
            tmp = now;
            now = Math.max(last + n, now);
            last = tmp;
        }
        return now;        
    }
```
