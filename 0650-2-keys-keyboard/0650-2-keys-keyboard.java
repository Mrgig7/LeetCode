class Solution {
    public int minSteps(int n) {
        int cur=1,res=0,cpy=0;
        while(cur<n){
            if(n%cur==0){
                cpy=cur;
                res++;
            }
            cur+=cpy;
            res++;
        }
        return res;
        
    }
}