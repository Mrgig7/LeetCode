class Solution {
    public String makeFancyString(String s) {
        StringBuilder r = new StringBuilder();
        char last = '-';
        int nb = 0;
        for (char c : s.toCharArray()) {
            if (c == last) {
                if (nb == 2) continue ;
                nb++;
            } else nb = 1;
            last = c;
            r.append(c);
        }  
        return r.toString();
    }
}