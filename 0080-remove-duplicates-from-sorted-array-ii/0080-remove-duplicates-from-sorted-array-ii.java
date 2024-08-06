class Solution {
    public int removeDuplicates(int[] arr) {
        int p1 = 0,p2 = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[p1] != arr[i]) {
                p1 = p2+1;
                arr[p1] = arr[i];
                p2 = p1;
            } else {
                p2 = p1 + 1;
                arr[p2] = arr[i];
            }
        }
        return p2 + 1;
    }
}