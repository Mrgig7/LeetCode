class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        int mi = arr.get(0).get(0);
        int ma = arr.get(0).get(arr.get(0).size() - 1);
        int md = 0;

        for (int i = 1; i < arr.size(); i++) {
            md = Math.max(md, Math.abs(arr.get(i).get(arr.get(i).size() - 1) - mi));
            md = Math.max(md, Math.abs(ma - arr.get(i).get(0)));
            mi = Math.min(mi, arr.get(i).get(0));
            ma = Math.max(ma, arr.get(i).get(arr.get(i).size() - 1));
        }

        return md;  
    }
}