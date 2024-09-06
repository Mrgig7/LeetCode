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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int ma = 0;
        for (int i : nums) 
            ma = Math.max(ma, i);

        boolean [] chk = new boolean[ma + 1];

        for (int i : nums) chk[i] = true;

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode curr = temp;

        while (head != null) {
            if(head.val <= ma && chk[head.val])
                temp.next = head.next;
            else
            temp = head;
            head = head.next;
        }

        return curr.next;
    }
}