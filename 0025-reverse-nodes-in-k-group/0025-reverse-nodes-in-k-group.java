class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        ListNode kprev = null;

        for(int i = 0; i < k; i++){
            if(node == null) return head;
            if(i == k-1) kprev = node;
            node = node.next;
        }

        kprev.next = null;

        reverseList(head);
        head.next = reverseKGroup(node, k);

        return kprev;
    }

    public void reverseList(ListNode head){
        if(head == null) return;

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}