QUestion: https://leetcode.com/problems/binary-tree-paths/
```
Renjia's Solution:
public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}
///////////////////
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<String>();
    if(root != null){
        res.addAll(binaryTreePaths(root.left));
        res.addAll(binaryTreePaths(root.right));
        for(int i=0; i < res.size();i++){
            String path = root.val+"->"+res.get(i);
            res.set(i,path);
        }

        if(res.size()==0) res.add(String.valueOf(root.val));
    }
    return res;

}
```
