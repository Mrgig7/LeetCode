class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] har = Arrays.copyOf(arr, arr.length);
        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 1;
        Arrays.sort(har);
        for (int num : har) {
            if (!mp.containsKey(num)) {
                mp.put(num, l);
                l++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }
}