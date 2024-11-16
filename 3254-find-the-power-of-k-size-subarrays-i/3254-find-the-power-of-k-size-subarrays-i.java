class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length ;
        int[] srt = new int[n] ;
        srt[0] = 0 ;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                srt[i]=srt[i-1]+1 ;
            }
            else srt[i]=srt[i-1] ;
        }
        int[] res = new int[n-k+1] ;
        for(int i=k-1;i<n;i++){
            int l = i-(k-1) ;
            int sele = srt[i]-srt[l] ;
            if(sele==k-1)res[i-(k-1)]=(nums[i]) ;
            else res[i-(k-1)]=(-1) ;
        }

        return res ;
    }
}