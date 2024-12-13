class Solution {
	int[] dp;
	int mod=1000000007;
	public int numDecodings(String s) {
		dp=new int[s.length()];
		char[] arr=s.toCharArray();
		int ans=fn(0,arr);

		return ans;
	}
	public int fn(int x,char[] arr){
		if(x>=arr.length){
			return 1;
		}else{
			if(dp[x]!=0||arr[x]=='0'){
				return dp[x]%mod;
			}
			int add=ru(arr,x);
			//ru denotes values  considering only 2 digit number 
			if(add!=0){
				add=(add*fn(x+2,arr)%mod)%mod;
			}
			int mp=1;
			if(arr[x]=='*'){
				mp=9;
			}
			if(x+1<arr.length&&arr[x+1]=='0'){
			//because in case of 0 it will always be a 2 digit number //10 or 20
				mp=0;
			}
			//mp denotes multiplier ie 9 when char is *
			dp[x]= (mp*fn(x+1,arr))%mod+add;
			return dp[x]%mod;
		}
	} 
	public int ru(char[] arr,int x){
		if(arr[x]=='*'){
			if(x+1<arr.length&&arr[x+1]=='*'){
			//11-19 &&21 to 26
				return 15;
			}
			if(x+1<arr.length&&(int)arr[x+1]-48<=6){
				return 2;
			}
			if(x+1<arr.length){
				return 1;
			}
			return 0;
		}else{
			if((int)arr[x]-48==1){
				if(x+1<arr.length&&arr[x+1]=='*'){
					return 9;
				}
				if(x+1<arr.length){
					return 1;
				}
				return 0;
			}
			if((int)arr[x]-48==2){
				if(x+1<arr.length&&arr[x+1]=='*'){
					return 6;
				}
				if(x+1<arr.length&&(int)arr[x+1]-48<=6){
					return 1;
				}
				return 0;
			}
			return 0;
		}
	}
}