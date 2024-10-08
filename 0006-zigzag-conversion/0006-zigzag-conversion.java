class Solution {
    public String convert(String s, int rows) {
        if (rows == 1 || rows >= s.length()) return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            int col = (rows * 2) - 2;
            int dia = i * 2;
            for (int j = i; j < n; j += col) {
                sb.append(s.charAt(j));
                if (dia > 0 && dia < col && j + col - dia < n) {
                    sb.append(s.charAt(j + col - dia));
                }
            }
        }
        return sb.toString();
    }
}