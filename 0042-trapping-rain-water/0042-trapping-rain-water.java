class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1 ;
        int res = 0;
        int mal = 0, mar = 0;

        while (l <= r) { 
            if (height[l] <= height[r]) {
                if (height[l] >= mal)
                    mal = height[l];
                else
                    res += mal - height[l];
                l++;
            } else { 
                if (height[r] >= mar)
                    mar = height[r];
                else
                    res += mar - height[r]; 
                r--;
            }
        }
        return res;
    }
}