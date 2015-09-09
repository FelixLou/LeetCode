Question: https://leetcode.com/problems/minimum-depth-of-binary-tree/
```
My solution:
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return min(root);
    }
    private int min(TreeNode root){
        if (root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = min(root.left);
        int right = min(root.right);
        return Math.min(left, right) + 1;
    }
///////////////////////
Renjia's solution:
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
    ///////////
       public static int minDepth(TreeNode root) {
    if (root == null)   return 0;
    if (root.left == null)  return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
}
///////////////
public int minDepth(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null || root.right == null) 
    return 1 + Math.max(minDepth(root.left), minDepth(root.right));
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```
