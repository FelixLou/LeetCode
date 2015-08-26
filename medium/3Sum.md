Question: https://leetcode.com/problems/3sum/
```
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0  && nums[i] == nums[i - 1]){
                continue;
            }
            int k = nums.length - 1;
            int j = i + 1;
            while(j < k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));// get 新技能
                    k--;
                    j++;
                    while(k > j && nums[k] == nums[k + 1]){
                        k--;  
                    }
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                }
                else if (nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }
```
