class Solution {
    public long minimumSteps(String s) {
        int n=s.length(),l=0,r=0;
        long cnt=0;
        while(r<n){
            char c=s.charAt(r);
            if(c=='0'){
            cnt+=r-l;
             l++;
            }
             r++;
        }
        return cnt;
    }
}