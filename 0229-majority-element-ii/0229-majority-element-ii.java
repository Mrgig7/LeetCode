class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int cnt1 = 0, cnt2 = 0, c1 = 0, c2 = 1;
        for (int num : nums) {
            if (num == c1)
                cnt1++;
            else if (num == c2)
                cnt2++;
            else if (cnt1 == 0) {
                c1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                c2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == c1)
                cnt1++;
            else if (num == c2)
                cnt2++;
        }
        if (cnt1 > nums.length / 3)
            res.add(c1);
        if (cnt2 > nums.length / 3)
            res.add(c2);
        return res;
    }
}