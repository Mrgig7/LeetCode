class Solution {
    public int maxUniqueSplit(String s){
        return dfs(s, new HashSet<>());
    }

    private int dfs(String s, Set<String>set){
        int ma = 0;
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(!set.contains(sub)){
                set.add(sub);
                ma = Math.max(ma, 1 + dfs(s.substring(i), set));
                set.remove(sub);
            }
        }
        return ma;   
    }
}