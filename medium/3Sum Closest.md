Question: https://leetcode.com/problems/3sum-closest/
```
My solution:
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int interval = Integer.MAX_VALUE;
        int sum = 0;
        int j = 1;
        int k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++){
            int target1 = target - nums[i];
            j = i + 1;
            k = nums.length -1;
            while(j < k){
                if (nums[j] + nums[k] == target1){
                    return target1 + nums[i];
                }
                else if (nums[j] + nums[k] > target1){
                    if (nums[j] + nums[k] - target1 < interval){
                        interval = nums[j] + nums[k] - target1;
                        sum = nums[i] + nums[j] + nums[k];
                    }
                   // System.out.println(">" + i + " " + j + " "+k + " "+sum + " " + interval );
                    k--;
                }
                else{
                    if (target1 - nums[j] - nums[k] < interval){
                        interval = target1 - nums[j] - nums[k];
                        sum = nums[i] + nums[j] + nums[k];
                    }
                   // System.out.println("<"+i + " "+ nums[i]+" " + j + " "+nums[j]+" "+k + " " +nums[k]+" "+sum + " " + interval );
                    j++;
                }
            }
        }
        return sum;
    }
////////////////////////////
Renjia's Solution:
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
```
