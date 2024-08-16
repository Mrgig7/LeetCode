class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int mi = arrays.get(0).get(0);
        int ma = arrays.get(0).get(arrays.get(0).size()-1);
        int res = 0;
        int n1 = mi; int n2 = mi;

        for(int i = 1 ; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int length = arr.size();
            n1 = arr.get(0);
            n2 = arr.get(length-1);
            if (n2 - mi > res) res = n2 - mi;
            if (ma - n1 > res) res = ma - n1;
            if (n1 < mi) mi = n1;
            if(n2 > ma) ma = n2;
        }

        return res;
    }
}