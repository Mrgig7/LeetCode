class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if (arr.length != m * n) {
            return new int[0][0];
        }
        int[][] td = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            td[i / n][i % n] = arr[i];
        }
        return td;
    }
}
