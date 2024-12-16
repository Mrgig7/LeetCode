class Solution {
    public int[] getFinalState(int[] arr, int k, int m) {
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            arr[idx] *= m;
        }
        return arr;
    }
}