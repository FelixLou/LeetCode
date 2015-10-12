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
class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 1
        high = len(nums)-1

        while low < high:
            mid = low+(high-low)/2
            count = 0
            for i in nums:
                if i <= mid:
                    count+=1
            if count <= mid:
                low = mid+1
            else:
                high = mid
        return low
```
