class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        int mi = arr.get(0).get(0);
        int ma = arr.get(0).get(arr.get(0).size()-1);
        int res = 0;
        int n1 = mi; int n2 = mi;

        for(int i = 1 ; i < arr.size(); i++) {
            List<Integer> arr = arr.get(i);
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