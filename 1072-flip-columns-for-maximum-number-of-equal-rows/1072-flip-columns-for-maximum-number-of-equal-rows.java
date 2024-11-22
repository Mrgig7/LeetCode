class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n=matrix.length; int ans=0;
        Map<String,Integer> map = new HashMap<>();

        for(int arr[]:matrix) {
            String s=conStr(arr);
            if(s.charAt(0)=='1') {
                s=flip(s);
            }
            map.put(s,map.getOrDefault(s,0)+1);
            ans = Math.max(ans,map.get(s));
        }
        return ans;
    }

    private String flip(String s) {
        String str="";
        for(char c:s.toCharArray()) {
            if(c=='0') {
                str +='1';
            } else {
                str +='0';
            }
        }
        return str;
    }

    private String conStr(int arr[]) {
        String str="";
        for(int i:arr) {
            str += String.valueOf(i);
        }
        return str;
    }
}