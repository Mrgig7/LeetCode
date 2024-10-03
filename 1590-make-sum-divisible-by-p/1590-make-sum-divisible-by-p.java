class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long ad = 0;
        for (int x : nums) ad += x;
        if (ad % p == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        ad %= p;
        int s = (int) ad;
        int l = n, mod = 0;

        for (int i = 0; i < n; i++) {
            mod = (nums[i] + mod) % p;
            map.put(mod, i);
            if (s == mod) l = Math.min(i + 1, l);
            if (map.containsKey((mod + p - s) % p)) 
                l = Math.min(l, i - map.get((mod + p - s) % p));
        }

        return l == n ? -1 : l;
    }
}