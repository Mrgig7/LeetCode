class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if(m*n != arr.length) return new int[0][0];
        int[][] td = new int[m][];
        for(int i=0; i<m; i++){
           td[i] = Arrays.copyOfRange(arr, i*n, i*n+n);
        }
        return td;
    }
}