class Solution {
    public String longestCommonPrefix(String[] a){
        Arrays.sort(a);
        int n = a.length-1;
        String s1 = a[0];
        String s2 = a[n];
        int s = 0;
        while(s<s1.length() && s<s2.length()){
            if(s1.charAt(s)==s2.charAt(s)){
                s++;
            }else{
                break;
            }
        }

        return s1.substring(0,s);
    }
}