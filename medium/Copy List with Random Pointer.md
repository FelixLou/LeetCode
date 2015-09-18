Question: https://leetcode.com/problems/copy-list-with-random-pointer/

Answer: https://leetcode.com/discuss/22421/solution-constant-space-complexity-linear-time-complexity

This answer use O(1) memory.
```
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode root = new RandomListNode(head.label);
        RandomListNode root2 = root;
        RandomListNode head2 = head;
        map.put(head2, root2);
        while(head2.next != null){
            head2 = head2.next;
            root2.next = new RandomListNode(head2.label);
            root2 = root2.next;
            map.put(head2, root2);
        }
        RandomListNode root3 = root;
        RandomListNode head3 = head;
        while(head3 != null){
            if(head3.random != null){
                root3.random = map.get(head3.random);   
            }
            root3 = root3.next;
            head3 = head3.next;
        }
        return root;
    }
```
