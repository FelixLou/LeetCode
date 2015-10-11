Question: https://leetcode.com/problems/largest-number/
```
class NumbersComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        return (s2+s1).compareTo(s1+s2);
    }
}
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "0";
        String[] numbers = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numbers[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numbers,new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            sb.append(numbers[i]);
        }
        String result = sb.toString();
        if(result.charAt(0) == '0') return "0";
        return result;
    }
}
```
