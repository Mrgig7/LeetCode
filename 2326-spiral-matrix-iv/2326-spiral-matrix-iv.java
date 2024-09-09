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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int mat[][] = new int[m][];
        for(int i = 0; i < m; i++) {
            mat[i] = new int[n];
            Arrays.fill(mat[i], -1);
        }
        int x1 = 0, y1 = 0, y2 = n - 1, x2 = m - 1;
        ListNode temp = head;
        while (temp != null) {
            for (int c = y1; c <= y2 && temp != null; c++) {
                mat[x1][c] = temp.val;
                temp = temp.next;
            }
            x1 += 1; 
            for (int r = x1; r <= x2 && temp != null; r++) {
                mat[r][y2] = temp.val;
                temp = temp.next;
            }
            y2 -= 1;
            for (int c = y2; c >= y1 && temp != null; c--) {
                mat[x2][c] = temp.val;
                temp = temp.next;
            }
            x2 -= 1; 
            for (int r = x2; r >= x1 && temp != null; r--) {
                mat[r][y1] = temp.val;
                temp = temp.next;
            }
            y1 += 1; 
        }
        return mat;
    }
}