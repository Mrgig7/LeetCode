class Solution {
    public int hIndex(int[] citi) {
        int n=citi.length;
        int[] cnt=new int[n+1];
        
        for(int c:citi){
            if(c>=n){
                cnt[n]++;
            }
            else{
                cnt[c]++;
            }
        }
        int res=0;
        for(int i=n;i>=0;i--){
            res+=cnt[i];
            if(res>=i){
                return i;
            }
        }
        
        return 0;
    }
}