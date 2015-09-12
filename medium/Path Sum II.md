Question: https://leetcode.com/problems/path-sum-ii/
```
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, result,list);
        return result;
        
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> result,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            result.add(new ArrayList<Integer>(list));
        }
        helper(root.left, sum - root.val, result, list);
        if(root.left != null)
            list.remove(list.size() -  1);
        helper(root.right, sum - root.val, result, list);
        if(root.right != null)
            list.remove(list.size() -  1);
    }
  //////////////////////////////////////
  public List<List<Integer>> pathSum(TreeNode root, int sum){
    List<List<Integer>> result  = new LinkedList<List<Integer>>();
    List<Integer> currentResult  = new LinkedList<Integer>();
    pathSum(root,sum,currentResult,result);
    return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
        List<List<Integer>> result) {

    if (root == null)
        return;
    currentResult.add(new Integer(root.val));
    if (root.left == null && root.right == null && sum == root.val) {
        result.add(new LinkedList(currentResult));
        currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
        return;
    } else {
        pathSum(root.left, sum - root.val, currentResult, result);
        pathSum(root.right, sum - root.val, currentResult, result);
    }
    currentResult.remove(currentResult.size() - 1);
}
```
