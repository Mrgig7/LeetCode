class Solution {
    public int reverse(int x) {
        int temp = x; 
        long rev = 0;

        while (temp != 0) { 
            rev = rev * 10 + temp % 10; 
            temp = temp / 10;
        }
        
        if (rev == (int) rev) { 
            return (int) rev;
        } else {
            return 0;
        }
    }
}