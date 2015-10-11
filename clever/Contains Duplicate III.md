Question: https://leetcode.com/problems/contains-duplicate-iii/
```
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            int minRange = nums[i] >= 0? nums[i] - t: (nums[i] - t > 0 ? Integer.MIN_VALUE: nums[i] - t);
            int maxRange = nums[i] <= 0? nums[i] + t: (nums[i] + t < 0) ? Integer.MAX_VALUE: nums[i] +t;
            for(int j = Math.max(minRange, min); j <= Math.min(max,maxRange); j++){
                if(map.containsKey(j) && i - map.get(j) <= k){
                    return true;
                }
            }
            min = Math.min(min,nums[i]);
            max = Math.max(max, nums[i]);
            map.put(nums[i],i);
        }
        return false;
    }
    //////////////////////////////////////
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
```
https://leetcode.com/discuss/38206/ac-o-n-solution-in-java-using-buckets-with-explanation
