class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];

        for(int i=0;i<nums.length;i++)  numsStr[i] = String.valueOf(nums[i]);

        Arrays.sort(numsStr, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if(numsStr[0].equals("0"))  return "0";

        StringBuilder result = new StringBuilder();
        for(String num : numsStr) result.append(num);

        return result.toString();
    }
}