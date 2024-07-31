class Solution {
    public int maxArea(int[] height) {
        int a = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = (height[i] > height[j] ? height[j] : height[i]);
            int a1 = h * (j - i);
            if (a1 > a)
                a = a1;
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return a;
    }
}