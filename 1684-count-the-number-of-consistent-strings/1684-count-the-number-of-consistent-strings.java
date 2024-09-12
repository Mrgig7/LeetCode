class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            arr[allowed.charAt(i) - 'a'] = true;
        }
        
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            boolean ischk = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!arr[words[i].charAt(j) - 'a']){
                    ischk = false;
                    break;
                }
            }
            if (ischk) {
                cnt++;
            }
        }
        
        return cnt;
    }
}