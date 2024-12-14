import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        
        // Deques to store indices for the sliding window min and max
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // Maintain minDeque: the front of the deque is the minimum value index
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // Maintain maxDeque: the front of the deque is the maximum value index
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Adjust left pointer when the condition max - min > 2
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                left++;
                
                // Remove indices out of the window
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
            }
            
            // Add the number of subarrays ending at 'right' to the answer
            ans += right - left + 1;
        }
        
        return ans;
    }
}
