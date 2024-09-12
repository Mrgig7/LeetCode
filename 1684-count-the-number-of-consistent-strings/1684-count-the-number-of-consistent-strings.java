class Solution {
    public int countConsistentStrings(String s1, String[] s2) {
        int n = s2.length;
        int arr[] = new int[26];
        for(char c : s1.toCharArray()){
            arr[c - 'a']++;
        }

        for(String s : s2){
            for(char c : s.toCharArray()){
                if(arr[c-'a']<=0){
                n--;
                break;
                }
            }
        }
        return n ;
    }
}