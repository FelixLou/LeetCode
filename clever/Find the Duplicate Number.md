Question: https://leetcode.com/problems/find-the-duplicate-number/
```
public int findDuplicate(int[] nums) {
    int fast, slow;

    fast = slow = nums[0];

    do {
        fast = nums[nums[fast]];
        slow = nums[slow];
    } while (fast != slow);

    slow = nums[0];
    while (fast != slow) {
        fast = nums[fast];
        slow = nums[slow];
    }

    return fast;
}
/////////////////////////////
    public int findDuplicate(int[] nums){
        if(nums.length == 2) return nums[0];
        int start = 1;
        int end = nums.length - 1;
        int mid = 0;
        
        while(start < end){
            mid = start + (end - start)/2;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count <= mid){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
```
