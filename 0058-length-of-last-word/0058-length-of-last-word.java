class Solution {
    public int lengthOfLastWord(String s) {
        String[] ls = s.split(" ");
        return ls[ls.length-1].length();
 
    }
}