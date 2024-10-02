class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sor = arr.clone();
        Arrays.sort(sor);
        HashMap<Integer, Integer> rm = new HashMap<>();
        int rank = 1;

        for (int num : sor) {
            if (!rm.containsKey(num)) {
                rm.put(num, rank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rm.get(arr[i]);
        }

        return arr;
    }
}
