class Solution {
    public boolean isPalindrome(String s) {
        int left = 0 , rigth = s.length()-1;
        while(left<rigth){
           char l = s.charAt(left) , h = s.charAt(rigth);
           if(!Character.isLetterOrDigit(l)) left++;
           else if(!Character.isLetterOrDigit(h)) rigth--;
           else {
               if(Character.toLowerCase(l)!=Character.toLowerCase(h)) return false;
               left++; rigth--;
           }  
        }
        return true;
    }
}