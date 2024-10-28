class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>mp=new HashMap<>();
        int ma=-1;
        for(int i=nums.length-1;i>=0;i--){
            int ele=nums[i];
            if(mp.containsKey(ele*ele)) mp.put(ele,mp.get(ele*ele)+1);
            else mp.put(ele,1);
            ma=Math.max(ma,mp.get(ele));
        }
        if(ma==1) return -1;
        
        return ma;
    }
}