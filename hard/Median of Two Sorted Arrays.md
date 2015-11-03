Question: https://leetcode.com/problems/median-of-two-sorted-arrays/
```
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0;
        int m = nums1.length;
        int n = nums2.length;
        if((m + n) % 2 == 1){
           return (double)findKth(nums1, 0, m -1, nums2, 0, n - 1, (m + n + 1)/2);
        }
        else{
            return ((double)findKth(nums1, 0, m -1, nums2, 0, n - 1, (m + n)/2) + (double)findKth(nums1, 0, m -1, nums2, 0, n - 1, (m + n)/2 + 1))/2;
        }
    } 

    private int findKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k){
        if(l1 > r1) return nums2[l2 + k - 1];
        if(l2 > r2) return nums1[l1 + k - 1];
        int m1 = (l1 + r1)/2;
        int m2 = (l2 + r2)/2;
        if(nums1[m1] <= nums2[m2]){
            if(m1 - l1 + 1 + m2 - l2 < k){
                return findKth(nums1, m1 + 1, r1, nums2, l2, r2, k - (m1 - l1) -1);
            }
            else{
                return findKth(nums1, l1, r1, nums2, l2, m2 - 1, k);
            }
            
        }
        else{
            if(m1 - l1 + 1 + m2 - l2 < k){
                return findKth(nums1, l1, r1, nums2, m2 + 1, r2, k - (m2 - l2) -1);
            }
            else{
                return findKth(nums1, l1, m1-1, nums2, l2, r2, k);
            }
        }
    }
}
```
