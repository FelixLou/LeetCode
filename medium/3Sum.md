Question: https://leetcode.com/problems/3sum/
```
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
      //  boolean[] visited = new boolean[nums.length];
        int k;
        //
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0  && nums[i] == nums[i - 1]){
               // visited[i] = true;
                continue;
            }
            k = nums.length - 1;
            //visited[i] = true;
            for (int j = i + 1; j < k;){
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
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
