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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int minSwap = 0;

        while(!q.isEmpty()){
            TreeNode curr = q.peek();
            int size = q.size();

            for(int i = 0; i < size; i++){
    
                curr = q.remove();

                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }

            int arr[] = new int[q.size()];
            int k = 0;
            for(TreeNode num : q){
                arr[k++] = num.val;
            }
            minSwap = minSwap + LevelOrderSwaps(arr,k);
        }
        return minSwap;
    }
    int LevelOrderSwaps(int arr[] , int n){
        int temp[] = Arrays.copyOfRange(arr, 0 , n);
        int ans = 0;
        Arrays.sort(temp);

        for(int i = 0; i<n; i++){
            if(arr[i] != temp[i]){
                ans++;
                int x = findIndex(arr, temp[i]);
                int tmp = arr[i];
                arr[i] = arr[x];
                arr[x] = tmp;

            }
        }
        return ans;
    }
    int findIndex(int arr[] , int x){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}