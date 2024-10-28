class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int ct = 0;
        for (int num : nums) {
            double val = Math.sqrt(num);
            if (Math.floor(val) == val && map.containsKey((int)val)) map.put(num, map.get((int)val) + 1);
            else map.put(num, 1);
            ct = Math.max(map.get(num), ct);
        }
        return ct < 2 ? -1 : ct;
    }
}