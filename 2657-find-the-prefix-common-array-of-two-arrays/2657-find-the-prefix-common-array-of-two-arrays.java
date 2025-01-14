class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[]arr = new int[n+1];
        int[]res = new int[n];

        int cnt = 0;
        for(int i = 0;i < n;i++){
            arr[A[i]]++;
            if(arr[A[i]] == 2)
                cnt++;
            arr[B[i]]++;
            if(arr[B[i]] == 2)
                cnt++;
            res[i] = cnt;
        }
        return res;
    }
}