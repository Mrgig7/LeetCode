class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long cnt = 0;
        for(int i : chalk){
            cnt+=i;
        }

        int rc =(int) (k % cnt);

        for(int i =0; i<chalk.length; i++){
            if(rc < chalk[i]){
                return i;
            }
            rc -= chalk[i];
        }

        return 0;
    }
}