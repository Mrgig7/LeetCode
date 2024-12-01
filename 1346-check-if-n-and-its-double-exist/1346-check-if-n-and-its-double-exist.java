class Solution {
    public boolean checkIfExist(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int z = 0;

        for (int n : a) {
            if (n == 0) {
                z++;
            } else {
                if (m.containsKey(2 * n) || (n % 2 == 0 && m.containsKey(n / 2))) {
                    return true;
                }
            }
            m.put(n, 1);
        }

        return z > 1;
    }
}