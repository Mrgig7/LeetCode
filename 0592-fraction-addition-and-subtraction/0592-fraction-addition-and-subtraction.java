class Solution {
    public String fractionAddition(String expr) {
        int n = expr.length();
        int num = 0;
        int d = 1;
        int i = 0;

        while (i < n) {
            int cn = 0;
            int cd = 0;

            boolean isNeg = (expr.charAt(i) == '-');
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') i++;

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                cn = (cn * 10) + val;
                i++;
            }
            i++;
            if (isNeg) cn *= -1;

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                cd = (cd * 10) + val;
                i++;
            }

            num = num * cd + d * cn;
            d = d * cd;
        }

        int gcd = gcd(Math.abs(num), d);
        num /= gcd;
        d /= gcd;

        return num + "/" + d;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}