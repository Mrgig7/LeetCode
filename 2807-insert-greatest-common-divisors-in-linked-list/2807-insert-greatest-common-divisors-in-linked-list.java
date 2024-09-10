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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null)return head;
        ListNode a=head,b=head.next;
        while(a.next!=null){
            ListNode k = new ListNode();
            k.val=gcd(a.val,b.val);
            a.next=k;
            k.next=b;
            a=b;
            b=b.next;
        }
        return head;
    }
    int gcd(int a,int b){
        if(b==0)return a;
       return gcd(b,a%b);
    }
}