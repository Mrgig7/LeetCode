class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        if (max == 0) 
            return new int[][] { intervals[0] };
        int[] tt = new int[max + 1];

        for (int i = 0; i < intervals.length; i++) {
            int st = intervals[i][0];
            int et = intervals[i][1];
            tt[st] =Math.max(et + 1, tt[st]);
        }
        int n = 0;
        int r = -1;
        int l = -1;

        for (int i = 0; i < tt.length; i++) {
            if (tt[i] != 0) {
                if (l == -1) {
                    l = i;
                }
                r = Math.max(tt[i] - 1, r);
            }
            if (r == i) {
                intervals[n++] = new int[] { l, r };
                r = -1;
                l = -1;
            }
        }
        if (l != -1) {
            intervals[n++] = new int[] { l, r };
        }
        if (intervals.length == n) {
            return intervals;
        }
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = intervals[i];
        }
        return res;
    }
}