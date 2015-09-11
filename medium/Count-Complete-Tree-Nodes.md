Question: https://leetcode.com/problems/count-complete-tree-nodes/
```
    public int countNodes(TreeNode root) {
        int h = findHeight(root);
        if(h < 0) return 0;
        else{
            return findHeight(root.right) == (h - 1)? (1<< h) + countNodes(root.right): (1 << h - 1) + countNodes(root.left);
        }
    }
    private int findHeight(TreeNode root){
        return root == null? -1: 1 + findHeight(root.left);
    }
    //////////////////////////////
        public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int nodes = 0;
        int h = findHeight(root);
        while(root != null){
            if(findHeight(root.right) == h - 1){
                nodes += 1<<h;
                root = root.right;
            }
            else{
                nodes += 1 << h- 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
    private int findHeight(TreeNode root){
        return root == null? -1: 1 + findHeight(root.left);
    }
```
