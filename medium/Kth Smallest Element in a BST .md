Question: Kth Smallest Element in a BST

https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
```
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(k != 0){
            TreeNode node = stack.pop();
            k--;
            if(k == 0){
                return node.val;
            }
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return -1;
    }
```
