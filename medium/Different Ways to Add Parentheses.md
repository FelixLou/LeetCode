Question: https://leetcode.com/problems/different-ways-to-add-parentheses/

map is just used to accelerate the process
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
////////////////////////////////////////////////////
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
```
