class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] mp = new double[n];
        mp[start_node] = 1.0;
        for (int i = 0; i < n - 1; i++) {
            boolean upd = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];
                if (mp[u] * prob > mp[v]) {
                    mp[v] = mp[u] * prob;
                    upd = true;
                }
                if (mp[v] * prob > mp[u]) {
                    mp[u] = mp[v] * prob;
                    upd = true; 
                }
            }
            if (!upd) break;
        }
        return mp[end_node];
    }
}