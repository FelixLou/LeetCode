Question: https://leetcode.com/problems/validate-binary-search-tree/
```
My solution:
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        for(int i = 0; i< list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }
/////////////////////////////////////////////////
Renjia's solution:
public boolean isValidBST (TreeNode root){
           Stack<TreeNode> stack = new Stack<TreeNode> ();
           TreeNode cur = root ;
           TreeNode pre = null ;           
           while (!stack.isEmpty() || cur != null) {               
               if (cur != null) {
                   stack.push(cur);
                   cur = cur.left ;
               } else {                
                   TreeNode p = stack.pop() ;
                   if (pre != null && p.val <= pre.val) {   //pre == null 记得！                   
                       return false ;
                   }                   
                   pre = p ;                       ////////get 新技能！
                   cur = p.right ;
               }
           }
           return true ; 
       }
///////////////////////////////////////////////
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
```
