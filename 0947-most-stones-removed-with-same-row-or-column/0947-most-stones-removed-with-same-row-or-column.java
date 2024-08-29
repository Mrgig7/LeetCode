

class Solution {
    public int removeStones(int[][] stn) {
        int n = stn.length;
        int mr = 0;
        int mc = 0;

        for (int i = 0; i < n; i++) {
            mr = Math.max(mr, stn[i][0]);
            mc = Math.max(mc, stn[i][1]);
        }

        DisjointSet ds = new DisjointSet(mr + mc + 1);
        HashMap<Integer, Integer> sn = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nr = stn[i][0];
            int nc = stn[i][1] + mr + 1;
            ds.unionBySize(nr, nc);
            sn.put(nr, 1);
            sn.put(nc, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : sn.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }

        return n - cnt;
    }
}

class DisjointSet {
    List<Integer> rk = new ArrayList<>();
    List<Integer> par = new ArrayList<>();
    List<Integer> si = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rk.add(0);
            par.add(i);
            si.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == par.get(node)) {
            return node;
        }
        int ulp = findUPar(par.get(node));
        par.set(node, ulp);
        return par.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (si.get(ulp_u) < si.get(ulp_v)) {
            par.set(ulp_u, ulp_v);
            si.set(ulp_v, si.get(ulp_v) + si.get(ulp_u));
        } else {
            par.set(ulp_v, ulp_u);
            si.set(ulp_u, si.get(ulp_u) + si.get(ulp_v));
        }
    }
}
