Question: https://leetcode.com/problems/longest-consecutive-sequence/
```
//My solution
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], 1);
        }
        int count = 1;
        int result = 0;
        HashMap<Integer, Integer> used = new HashMap<Integer, Integer>();
        for (int i = 0; i < map.size(); i++){
            if (used.containsKey(nums[i])){
                continue;
            }
            int min = nums[i];
            int max = nums[i];
            used.put(min, 1);
            while (map.containsKey(min - 1)){
                used.put(min - 1, 1);
                min = min - 1;
                count++;
            }
            while (map.containsKey(max + 1)){
                used.put(max + 1, 1);
                max = max + 1;
                count++;
            }
            result = Math.max(result, count);
            count = 1;
        }
        return result;
    }
//////////////////////////////////////////////////////
//RenJia's solution 
public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);

            // keep track of the max length 
            res = Math.max(res, sum);

            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            // duplicates
            continue;
        }
    }
    return res;
}
```
