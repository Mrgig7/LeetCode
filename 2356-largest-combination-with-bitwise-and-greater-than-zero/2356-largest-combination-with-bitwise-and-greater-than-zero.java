
class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[32]; // Array to count the number of candidates with each bit set

        // Count the number of candidates with each bit set
        for (int candidate : candidates) {
            for (int bit = 0; bit < 32; bit++) {
                if ((candidate & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        // Find the maximum count across all bit positions
        int maxCount = 0;
        for (int count : bitCount) {
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}