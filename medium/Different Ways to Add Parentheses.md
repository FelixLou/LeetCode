Question: https://leetcode.com/problems/different-ways-to-add-parentheses/
```
    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
       if (map.containsKey(input)) {
           return map.get(input);
       }
       List<Integer> result = new ArrayList<Integer>();
       int n = input.length();
       for (int i = 0; i < n; i++) {
            char current = input.charAt(i);
            if (current >= '0' && current <= '9') {
                continue;
            }
            List<Integer> first = diffWaysToCompute(input.substring(0, i));
            List<Integer> second = diffWaysToCompute(input.substring(i + 1, n));
            for (Integer left: first) {
                for (Integer right: second) {
                    switch(current) {
                        case '+': result.add(left + right); break;
                        case '-': result.add(left - right); break;
                        case '*': result.add(left * right); break;
                    }
                }
            }
        }
        if (result.isEmpty() && n != 0) {
            result.add(Integer.parseInt(input));
        }
        map.put(input, result);
        return result;
    }
```
