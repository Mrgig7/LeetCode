class Solution {
 public void swap(List<Integer> b, int i, int j) {
        int t = b.get(i);
        b.set(i, b.get(j));
        b.set(j, t);
    }

    public void permutations(List<List<Integer>> a, List<Integer> b, int i) {
        if (i == b.size()) {
            a.add(new ArrayList<>(b));
            return;
        }

        for (int j = i; j < b.size(); j++) {
            swap(b, i, j);
            permutations(a, b, i + 1);
            swap(b, i, j);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int ele : nums) {
            b.add(ele);
        }
        permutations(a, b, 0);
        return a;
    }
}