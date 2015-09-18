Question: https://leetcode.com/problems/4sum/
```
My solution:
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        int m = nums.length - 1;
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1; k < Math.min(nums.length - 1, m); k++){
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if(nums[i] + nums[j] + nums[k] + nums[m] == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                    }
                    else if(nums[i] + nums[j] + nums[k] + nums[m] > target && m > k + 1){
                        m--;
                        k--;
                    }
                    while(m < nums.length - 1 && nums[m] == nums[m + 1] && m > k + 1){
                        m--;
                    }
                }
                m = nums.length - 1;
            }
        }
        return result;
    }
```
