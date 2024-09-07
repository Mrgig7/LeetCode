class Solution {
    public int strStr(String a, String b) {
        for(int i = 0, j = b.length(); j<=a.length(); i++,j++){
            if(a.substring(i,j).equals(b)){
                return i;
            }
        }
        return -1;
    }
}