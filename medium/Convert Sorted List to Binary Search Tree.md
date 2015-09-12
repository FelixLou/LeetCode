Question: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
```
recursive:
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode tmp = findMid(head);
        ListNode mid = tmp.next;
        TreeNode root = new TreeNode(mid.val);
        tmp.next = null;
        root.right = sortedListToBST(mid.next);
        root.left = sortedListToBST(head);           
        return root;
        
    }
    private ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode tmp = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
        }
        return tmp;
    }
/////////////////////////////
  public TreeNode sortedListToBST(ListNode head) {
    if(head==null)
        return null;
    ListNode slow = head;
    ListNode fast = head;
    ListNode temp=null;

    //find the mid node
    while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        temp = slow;
        slow = slow.next;
    }

    if(temp!=null)
        temp.next = null; //break the link
    else
        head = null;

    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
}
```
