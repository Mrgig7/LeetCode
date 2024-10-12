class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] st = new int[n];
        int[] et = new int[n];
        for (int i = 0; i < n; i++) {
            st[i] = intervals[i][0];
            et[i] = intervals[i][1];
        }
        Arrays.sort(st);
        Arrays.sort(et);
        int ep = 0, gcnt = 0;
        for (int s : st) {
            if (s > et[ep]) {
                ep++;
            } else {
                gcnt++;
            }
        }

        return gcnt;
    }
}