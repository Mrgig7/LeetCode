

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sor = arr.clone();
        Arrays.sort(sor);
        int[] rank = new int[arr.length];
        int r = 1;
        for (int i = 0; i < sor.length; i++) {
            if (i == 0 || sor[i] != sor[i - 1]) {
                rank[i] = r++;
            } else {
                rank[i] = rank[i - 1];
            }
        }
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sor.length; j++) {
                if (arr[i] == sor[j]) {
                    result[i] = rank[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
