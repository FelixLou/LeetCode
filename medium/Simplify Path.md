Question: https://leetcode.com/problems/simplify-path/
```
My solution:
	   public String simplifyPath(String path) {
	        if (path == null || path.length() == 0){
	            return "";
	        }
	        
	        String[] res = new String[1];
	        res = path.split("/");
	        int length = res.length;
	        StringBuilder result = new StringBuilder();
	        result.append("/");
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.push(1);
	        for (int i = 0; i < length; i++){
	        	//System.out.println(res[i]);
	            if (res[i].equals("") || res[i].equals(".")){
	                continue;
	            }
	            else if (res[i].equals("..")){
	                if (!stack.isEmpty()){
	                    result.delete(stack.pop(), result.length());
	                }
	            }
	            else{
	                stack.push(result.length());
	                result.append(res[i] + "/");
	                
	            }
	        }
	        if (result.length() != 1){
	            result.delete(result.length() - 1, result.length());
	        }
	        return result.toString();
	    }
//////////////////////////////////////////////
Renjia's solution:
直接用stack来存！！！
public String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();   get 新技能！ stack 的itertor有问题， obselete了， 用Deque吧
    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    for (String dir : path.split("/")) {
        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
        else if (!skip.contains(dir)) stack.push(dir);
    }
    String res = "";
    for (String dir : stack) res = "/" + dir + res;
    return res.isEmpty() ? "/" : res;
}
///////////////////////////////////////////
public String simplifyPath(String path) {
    StringBuilder sb = new StringBuilder("/");
    LinkedList<String> stack = new LinkedList<String>();
    for(String s: path.split("/")){
        if(s.equals("..")){
            if(!stack.isEmpty())
                stack.removeLast();
        }
        else if(!s.equals("") && !s.equals("."))
            stack.add(s);
    }
    for(String s: stack){
        sb.append(s+"/");
    }
    if(!stack.isEmpty()) sb.setLength(sb.length()-1);
    return sb.toString();
}
