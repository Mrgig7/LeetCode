class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int nA = edges[i][0], nB = edges[i][1];
            adj[nA].add(new int[]{nB, i});
            adj[nB].add(new int[]{nA, i}); 
        }

        int[][] dists = new int[n][2];
        Arrays.fill(dists[source], 0);
        for (int i = 0; i < n; i++) {
            if (i != source) {
                dists[i][0] = dists[i][1] = Integer.MAX_VALUE;
            }
        }

        dijk(adj, edges, dists, source, 0, 0);
        int difference = target - dists[destination][0];
        if (difference < 0) return new int[][]{}; 
        dijk(adj, edges, dists, source, difference, 1);
        if (dists[destination][1] < target) return new int[][]{}; 

        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1; 
        }
        return edges;
    }

    private void dijk(List<int[]>[] adj, int[][] edges, int[][] dists, int source, int difference, int run) {
        int n = adj.length;
        PriorityQueue <int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});
        dists[source][run] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > dists[currentNode][run]) continue;

            for (int[] neighbor : adj[currentNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2];

                if (weight == -1) weight = 1; 

                if (run == 1 && edges[edgeIndex][2] == -1) {
           
                    int newWeight = difference + dists[nextNode][0] - dists[currentNode][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight; 
                    }
                }

                if (dists[nextNode][run] > dists[currentNode][run] + weight) {
                    dists[nextNode][run] = dists[currentNode][run] + weight;
                    pq.add(new int[]{nextNode, dists[nextNode][run]});
                }
            }
        }
    }
}