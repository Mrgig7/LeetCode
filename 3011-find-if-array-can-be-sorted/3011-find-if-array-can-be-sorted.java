class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] sb = new int[n];
        
        for (int i = 0; i < n; i++) {
            sb[i] = Integer.bitCount(nums[i]);
        }
        
        for (int i = 0; i < n - 2 ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sb[j] > sb[j + 1] || 
                   (sb[j] == sb[j + 1] && nums[j] > nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    
                    temp = sb[j];
                    sb[j] = sb[j + 1];
                    sb[j + 1] = temp;
                }
            }
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}