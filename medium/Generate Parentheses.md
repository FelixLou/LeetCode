Question: https://leetcode.com/problems/generate-parentheses/
DFS 活学活用啊，衰！
```
    public List<String> generateParenthesis(int n) {  
        List<String> res = new ArrayList<String>();
        if (n<=0){
            return res;
        }  
        String item = new String();
        dfs(res,item,n,n);  
        return res;  
    }  
      
    public void dfs(List<String> res, String item, int left, int right){ 
        if(left > right)//deal wiith ")("
            return;
            
        if (left == 0 && right == 0){  
            res.add(new String(item));  
            return;  
        }
        
        if (left>0) 
            dfs(res,item+'(',left-1,right);  
        if (right>0) 
            dfs(res,item+')',left,right-1);  
    }
```
