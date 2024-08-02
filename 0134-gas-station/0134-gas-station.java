class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int ts = 0,s = 0,st = 0;
        for(int i = 0; i < n; i++){
            ts += gas[i] - cost[i];
            s += gas[i] - cost[i];
            if(s < 0){
                s = 0;
                st = i + 1;
            }
        }
        return (ts < 0) ? -1 : st;
    }
}