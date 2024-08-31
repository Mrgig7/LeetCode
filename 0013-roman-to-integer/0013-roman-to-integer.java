class Solution {
    public int romanToInt(String s) {
        int val = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);

            if (i + 1 < n && getValue(s.charAt(i + 1)) > getValue(cur)) {
                val -= getValue(cur);
            } else {
                val += getValue(cur);
            }
        }

        return val;
    }

    private int getValue(char rn) {
        switch (rn) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}