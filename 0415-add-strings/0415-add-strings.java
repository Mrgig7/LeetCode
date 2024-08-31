class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, k = 0;

        while(i >= 0 || j >= 0 || k != 0)
        {
            int ad = 0;
            if( i >= 0)
            {
                ad += (num1.charAt(i) - '0');
                i--;
            }
            if( j >= 0 )
            {
                ad += (num2.charAt(j) - '0');
                j--;
            }

            ad += k;
            k = ad / 10;
            res.append(ad % 10);
        }

        return res.reverse().toString();
    }
}