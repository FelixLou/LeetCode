Question: https://leetcode.com/problems/reverse-linked-list-ii/
```
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy2 = dummy;
        for(int i = 0; i < m - 1;i++){
            dummy2 = dummy2.next;
        }
      //  ListNode tmp = dummy2.next;
        ListNode start = dummy2.next;
        ListNode then = start.next;
        for(int i = m; i < n; i++){
            start.next = then.next;
            then.next = dummy2.next;
            dummy2.next = then;
            then = start.next;
        }
        return dummy.next;
    }
```
