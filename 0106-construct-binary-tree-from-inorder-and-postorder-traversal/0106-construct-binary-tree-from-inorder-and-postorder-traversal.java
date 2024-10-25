/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder. length == 0 || postorder.length == 0) return null;
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = 1;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                inRoot = i;
                break;
            }
        }
        int leftLen = inRoot - inStart;
        root.left = helper(inorder, postorder, inStart, inRoot-1, postStart, postStart+leftLen-1);
        root.right = helper(inorder, postorder, inRoot+1, inEnd, postStart+leftLen, postEnd-1);
        return root;
    }
}