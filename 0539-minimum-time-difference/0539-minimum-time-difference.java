class Solution {
    public int findMinDifference(List<String> times) {
        boolean[] vis = new boolean[24 * 60];
        for (String time : times) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            if (vis[h * 60 + m]) return 0; 
            vis[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = 0, last = 0;
        int idx = vis.length - 1; 
        
      
        while(!vis[idx])
            idx--;  
        last = idx;
    
        idx = 0;
        while(!vis[idx])
            idx++;
        first = idx;
        
        prev = first;
        for(int i = first + 1; i <= last; i++){
            if(vis[i]){
                min = Math.min(min, i - prev);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        return min;
    }
}