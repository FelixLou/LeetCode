Question: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
```
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = new ListNode(0);
        ListNode backup = pre;
        pre.next = head;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }
            else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return backup.next;
    }
```
