Question: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
```
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null
				|| inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int size = inorder.length;
		for (int i = 0; i < inorder.length; ++i) {
			hm.put(inorder[i], i);
		}
		return helper(inorder, 0, size - 1, postorder, 0, size - 1, hm);

	}

	private TreeNode helper(int[] inorder, int start1, int end1,
			int[] postorder, int start2, int end2, HashMap<Integer, Integer> hm) {
		if (end1 < start1 || end2 < start2) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[end2]);
		int index = hm.get(postorder[end2]);
		root.left = helper(inorder, start1, index - 1, postorder, start2,
				start2 + index - 1 - start1, hm);
		root.right = helper(inorder, index + 1, end1, postorder, start2 + index
				- start1, end2 - 1, hm);
		return root;
	}
```
