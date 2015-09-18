Question: https://leetcode.com/problems/palindrome-linked-list/
```
O(n) and O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode head1 = head;
        int n = 0;
        while(head1 != null){
            n++;
            head1 = head1.next;
        }
        ListNode head2 = head;
        ListNode pre = null;
        for(int i = 0; i < n/2; i++){
            ListNode tmp = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = tmp;
        }
        if(n % 2 == 1) head2 = head2.next;
        while(head2 != null){
            if(pre.val != head2.val){
                return false;
            }
            head2 = head2.next;
            pre = pre.next;
        }
        return true;
    }
```
