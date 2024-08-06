class Solution {
    public int maxSubArray(int[] n) {
        
        int ma=n[0],s=0;

        for(int i=0;i<n.length;i++)
        {
            s+=n[i];
            ma=s>ma?s:ma;

            if(s<0) s=0;
        }
        return ma;
    }
}