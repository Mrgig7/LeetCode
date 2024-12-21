class Solution {
    int count; 
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        count = 0; 
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v); 
            adj[v].add(u); 
        }
        find(0, -1, adj, values, k);

        return count;
    }


    private int find(int curr, int prev, ArrayList<Integer>[] adj, int[] values, int k) {
        int sum = 0; 
        for (int v : adj[curr]) {
            if (v == prev) continue; 
            sum += find(v, curr, adj, values, k); 
        }
        sum += values[curr]; 
        sum = sum % k; 
        if (sum == 0) {
            count++; 
        }
        return sum;
    }
}