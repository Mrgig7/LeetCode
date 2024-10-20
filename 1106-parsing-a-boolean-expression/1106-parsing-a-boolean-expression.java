class Solution {
    public boolean parseBoolExpr(String e) {
        return eval(e, new int[]{0}).res;
    }

    private Res eval(String s, int[] idx) {
        char c = s.charAt(idx[0]);

        if (c == 't') {
            idx[0]++;
            return new Res(true, idx[0]);
        }
        if (c == 'f') {
            idx[0]++;
            return new Res(false, idx[0]);
        }

        boolean r = (c == '&');
        idx[0] += 2;
        while (idx[0] < s.length() && s.charAt(idx[0]) != ')') {
            Res res = eval(s, idx);
            if (c == '|') r |= res.res;
            else if (c == '&') r &= res.res;
            else r = !res.res;
            if (idx[0] < s.length() && s.charAt(idx[0]) == ',') idx[0]++;
        }

        idx[0]++; 
        return new Res(r, idx[0]);
    }

    private static class Res {
        boolean res;
        int idx;

        Res(boolean r, int i) {
            res = r;
            idx = i;
        }
    }
}