class Solution {
    public int smallestChair(int[][] t, int tf) {
        int n = t.length;
        int[][] h = new int[n][4];
        for(int i=0; i<t.length; i++) {
            h[i] = new int[]{t[i][0], t[i][1], i, -1};
        }
        Arrays.sort(h, (a,b)->(a[0]-b[0]));
        int ch = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) ->(a[1]-b[1]));
        PriorityQueue<Integer> av = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            while(!pq.isEmpty() && pq.peek()[1]<=h[i][0]) {
                av.offer(pq.poll()[3]);
            }
            int curr = (!av.isEmpty()) ? av.poll() : ch++;
            if(h[i][2]==tf)
            return curr;
            h[i][3]=curr;
            pq.offer(h[i]); 
        }
        return -1;    
    }
}