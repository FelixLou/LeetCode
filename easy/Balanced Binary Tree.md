Question: https://leetcode.com/problems/balanced-binary-tree/
```
My solution:
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if (Math.abs(deepth(root.left, 0) - deepth(root.right, 0)) > 1){
            return false;
        }
        else{
            boolean left =  isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return left && right;
        }
    }
    private int deepth(TreeNode root, int deep){
        if (root == null){
            return deep;
        }
        int left = deepth(root.left, deep + 1);
        int right = deepth(root.right, deep + 1);
        return Math.max(left,right);
    }
```
Renjia's Solution:(C++)
https://leetcode.com/discuss/22898/the-bottom-up-o-n-solution-would-be-better
```
Top down:
class solution {
public:
    int depth (TreeNode *root) {
        if (root == NULL) return 0;
        return max (depth(root -> left), depth (root -> right)) + 1;
    }

    bool isBalanced (TreeNode *root) {
        if (root == NULL) return true;

        int left=depth(root->left);
        int right=depth(root->right);

        return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
};
Bottom up:
class solution {
public:
int dfsHeight (TreeNode *root) {
        if (root == NULL) return 0;

        int leftHeight = dfsHeight (root -> left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root -> right);
        if (rightHeight == -1) return -1;

        if (abs(leftHeight - rightHeight) > 1)  return -1;
        return max (leftHeight, rightHeight) + 1;
    }
    bool isBalanced(TreeNode *root) {
        return dfsHeight (root) != -1;
    }
};

Java：
    public boolean isBalanced(TreeNode root) {
        return dfsTree(root) != -1;
        
    }   
    private int dfsTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = dfsTree(root.left);
        int rightHeight = dfsTree(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight- rightHeight) > 1){
            return -1;            //get 新技能！用-1表示false！
        }
        return Math.max (leftHeight, rightHeight) + 1;
    }
```
