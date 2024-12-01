class Solution {
    public long minimumTotalDistance(List<Integer> r, int[][] f) {
        int[] robots = new int[r.size()];
        int k = 0;
        for(Integer i : r)
            robots[k++] = i;

        Arrays.sort(robots);
        Arrays.sort(f, (a, b) -> Integer.compare(a[0], b[0]));

        long[][] m = new long[robots.length][f.length];
        for (long[] row : m)
            Arrays.fill(row, -1);

        return recursion(robots, f, 0, 0, m);
    }

    public long recursion(int[] robots, int[][] factory, int i, int j, long[][] memo) {
        if (i == robots.length)
            return 0; 
        if (j == factory.length)
            return Long.MAX_VALUE / 2; 

        if (memo[i][j] != -1)
            return memo[i][j];

        long skip = recursion(robots, factory, i, j + 1, memo);

        long min = skip;
        long assign = 0;

        for (int k = 0; k < factory[j][1] && i + k < robots.length; k++) {
            assign += Math.abs(robots[i + k] - factory[j][0]);
            min = Math.min(min, assign + recursion(robots, factory, i + k + 1, j + 1, memo));
        }

        return memo[i][j] = min;
    }
}