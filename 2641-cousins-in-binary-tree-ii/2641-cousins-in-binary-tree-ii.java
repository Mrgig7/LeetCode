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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root.left == null && root.right == null) return new TreeNode(0);
        TreeNode nroot = null;
        dfs1(root, 0);
        dfs2(root, 0, root.val);
        return root;
    }
    private void dfs1(TreeNode root, int depth){
        if(root == null) return;
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        dfs1(root.left, depth+1);
        dfs1(root.right, depth+1);    
    }
    private void dfs2(TreeNode root, int depth, int sib){
        if(root == null) return;
        root.val = map.get(depth) - sib;
        sib = (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val);
        dfs2(root.left, depth+1, sib);
        dfs2(root.right, depth+1, sib);                    
    }
}