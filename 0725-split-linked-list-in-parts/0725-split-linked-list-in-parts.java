/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = Sl(head);
        ListNode[] ele = new ListNode[k];
        ListNode curr = head;
        int grp = n / k;
        int rem = n % k;

        for (int i = 0; i < k; i++) {
            int put = grp;
            if (rem > 0) {
                put++;
                rem--;
            }
            
            if (curr == null) {
                ele[i] = null;
            } else {
                ele[i] = curr;
                curr = curr.next;
                ListNode prev = ele[i];
                for (int j = 1; j < put; j++) {
                    prev.next = curr;
                    prev = prev.next;
                    curr = curr.next;
                }
                prev.next = null;
            }
        }
        return ele;
    }

    private int Sl(ListNode curr) {
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        return n;
    }
}
