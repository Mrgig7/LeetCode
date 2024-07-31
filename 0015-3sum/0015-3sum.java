class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        int s = 0;
            for(int i = 0; i < nums.length-1; i++){
                 int l = i + 1;
                  int h = nums.length -1;
            while(l < h){                
                s = nums[i] + nums[l] + nums[h];
                if(s == 0){
                    list.add(Arrays.asList(nums[i], nums[l],nums[h]));
                    l++;
                    h--;
                }
                else if(s < 0){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        return new ArrayList<>(list);
    }
}