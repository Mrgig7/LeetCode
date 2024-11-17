class Solution {
    public int shortestSubarray(int[] nums, int K) {
        int n = nums.length;
     
        int[] pres = new int[n+1];
        for (int i = 0; i < n; i++) {
            pres[i+1] = pres[i] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        Deque <Integer> dq = new LinkedList<>();

        for (int k = 0; k < n; k++) {
            dq.offerLast(k);
            while (!dq.isEmpty() && pres[k+1] - pres[dq.peekLast()] <= 0) {
                dq.pollLast();
            }
            while (!dq.isEmpty() && pres[k+1] - pres[dq.peekFirst()] >= K) {
                res = Math.min(res, k - dq.pollFirst() + 1);
            }    
        }
        return res == Integer.MAX_VALUE ? -1 : res;   
    }
}