class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList();
        for(int i = 1; i < 10; i++) 
        {
        
            dfs(i, n, ans);
        }
        return ans;
    }
    private void dfs(int curr, int n, List<Integer> ans)
    {
        
        if(curr > n) return;
        ans.add(curr);
        int nxt = 1;
        for(int j = 0; j < 10; j++)
        {
            nxt = curr * 10 + j;
            if(nxt > n) return;
            dfs(nxt, n, ans); 
        }
    }
}