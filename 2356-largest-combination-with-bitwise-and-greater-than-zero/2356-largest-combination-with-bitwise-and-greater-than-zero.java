class Solution {
    public int largestCombination(int[] nums) {
        int ma = 0;
        for(int i = 0; i< 24; i++){
            int cnt = 0;
            for(int num : nums){
                if((num & ( 1<< i)) != 0) cnt++;
            }

            ma = Math.max(ma, cnt);
        }

        return ma;
    }
}