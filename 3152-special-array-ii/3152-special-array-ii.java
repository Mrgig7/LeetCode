class Solution {
    public boolean[] isArraySpecial(int[] n, int[][] q) {
        boolean e = n[0] % 2 == 0;
        int c = 1;
        int[] a = new int[n.length];
        a[0] = c;

        for (int i = 0; i < n.length; i++) {
            if (e && isEven(n[i])) {
                e = false;
            } else if (!e && !isEven(n[i])) {
                e = true;
            } else {
                c++;
                e = n[i] % 2 != 0;
            }
            a[i] = c;
        }

        boolean[] r = new boolean[q.length];

        for (int i = 0; i < q.length; i++) {
            r[i] = a[q[i][1]] == a[q[i][0]];
        }

        return r;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}