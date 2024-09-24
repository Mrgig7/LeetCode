class Solution {
    public TreeSet<Integer> solve(int[] arr) {
        TreeSet<Integer> res = new TreeSet();
        for(int a : arr) {
            do{
                res.add(a);
                a = a/10;
            } while(a > 0);
        }
        return res;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TreeSet<Integer> a1 = solve(arr1);
        TreeSet<Integer> a2 = solve(arr2);
        a2.retainAll(a1);
        return (a2.isEmpty()) ? 0 : String.valueOf(a2.last()).length();
    }
    
}