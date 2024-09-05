class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int t=mean*(n+rolls.length); 
        int s = 0;
        for (int i = 0; i < rolls.length; i++){
            s += rolls[i];
        }
        
        int dif = t - s ,div = dif / n,rem = dif % n;
        if (div == 0 || dif < 0 || n * 6 < t - s){
            return new int[] {};
        }
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++){
            res[i] = div;
			if (rem > 0){
				res[i]++;
				rem--;
			}
        }
        return res;
    }
}