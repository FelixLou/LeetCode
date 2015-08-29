Question: https://leetcode.com/problems/majority-element-ii/
```
public List<Integer> majorityElement(int[] nums) {
    List<Integer> result=new ArrayList<Integer>();
    if(nums == null || nums.length == 0){
        return result;
    } 
    int candi1 = 0, candi2 = 1, count1 = 0, count2 = 0;
    for(int num : nums){
        if(num == candi1) count1++;
        else if(num == candi2) count2++;
        else if (count1 == 0) {candi1 = num; count1++;}
        else if (count2 == 0) {candi2 = num; count2++;}
        else {
            count1--;
            count2--;
        }
    }
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < nums.length; i++){
        if (nums[i] == candi1){
            count1++;
        }
        if (nums[i] == candi2){
            count2++;
        }
    }
    if (count1 > nums.length/3){
        result.add(candi1);
    }
    if (count2 > nums.length/3){
        result.add(candi2);
    }
    return result;
}
```
