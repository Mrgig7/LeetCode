class Solution {
    public int findMin(int[] nums) {
        int min = 1000000000;
        for(int a : nums){
            min = Math.min(a,min);
        }

        return min;

    }
}