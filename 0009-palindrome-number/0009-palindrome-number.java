class Solution {
    public boolean isPalindrome(int x) {
       //without converting into string
        if(x<0 || x%10==0) return false;
        if(x==0) return true;
        if(x<10 ) return true;
        int c = 0;
        while(x>c){
            c = c *10+ x%10;
            x /= 10;
        }

        return (x==c|| x == c/10);
       
    }
}