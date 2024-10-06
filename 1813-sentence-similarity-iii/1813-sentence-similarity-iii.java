class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        var l1 = s1.split(" ");
        var l2 = s2.split(" ");
        if (l1.length < l2.length) {
            var t = l1;
            l1 = l2;
            l2 = t;
        }
        int m = l1.length, n = l2.length;
        int i = 0, j = 0;
        while (i < n && l1[i].equals(l2[i])) ++i;
        while (j < n && l1[m - 1 - j].equals(l2[n - 1 - j])) ++j;
        return i + j >= n;
    }
}