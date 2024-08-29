class Solution {
    public int numis = 0;

    public int removeStones(int[][] stns) {
        int[] par = new int[20003];
        for (int[] stone : stns) {
            unionSets(stone[0] + 1, stone[1] + 10002, par);
        }
        return stns.length - numis;
    }

    public void unionSets(int a, int b, int[] par) {
        int parA = findpar(a, par), parB = findpar(b, par);
        if (parA != parB) {
            par[parB] = parA;
            numis--;
        }
    }

    public int findpar(int node, int[] par) {
        if (par[node] == 0) {
            par[node] = node;
            numis++;
        }
        if (par[node] == node) {
            return node;
        }
        int parentNode = findpar(par[node], par);
        par[node] = parentNode;
        return parentNode;
    }
}
