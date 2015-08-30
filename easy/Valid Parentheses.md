Question: https://leetcode.com/problems/valid-parentheses/
```
 	   public boolean isValid(String s) {
	        if (s == null || s.length() == 0){
	            return true;
	        }
	        HashMap<Character, Character> map = new HashMap<Character, Character>();
	        map.put('{','}');
	        map.put('[',']');
	        map.put('(',')');
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < s.length(); i++){
	            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
	                stack.push(s.charAt(i));
	            }
	            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
	                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)){
	                    return false;
	                }
	                else{
	                    stack.pop();
	                }
	            }
	        }
	        return stack.isEmpty();
	    }
```
