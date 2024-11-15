class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while(left < n-1 && arr[left] <= arr[left + 1]){
            left++;
        }
        if(left == n - 1){
            return 0;
        }
        int right = n-1;
        while(right >= 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        int ans = Math.min(right,n - left - 1);
        int p1 = 0,p2 = right;
        while((p1 <= left) && (p2 < n)){
            if(arr[p1] <= arr[p2]){
                ans = Math.min(ans,p2 - p1 -1);
                p1++;
            }else{
                p2++;
            }
        }
        return ans;
    }
}