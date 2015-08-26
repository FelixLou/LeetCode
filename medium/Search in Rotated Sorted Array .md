Question: https://leetcode.com/problems/search-in-rotated-sorted-array/
```
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length -1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[0]){
                if (nums[mid] > target && target >= nums[0]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if (nums[mid] < target && target <= nums[nums.length - 1]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
```
