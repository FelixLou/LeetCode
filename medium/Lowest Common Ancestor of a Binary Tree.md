Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
```
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        return getAncessor(root, p, q);
    }
    
    private TreeNode getAncessor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        //Divide
        TreeNode left = getAncessor(root.left, p, q);
        TreeNode right = getAncessor(root.right, p, q);
        //Conquer
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
/////////////////////////////////////
Renjia's solution:
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
```
