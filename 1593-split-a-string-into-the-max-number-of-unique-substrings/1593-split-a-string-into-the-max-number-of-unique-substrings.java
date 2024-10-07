class Solution {
    public int backtrack(String s, int st, Set<String> set){
        int ma = 0;
        if(st == s.length()) return 0;
        
        for(int i=st+1; i<=s.length(); i++){
            String sub = s.substring(st, i);
            if(!set.contains(sub)){
                set.add(sub);
                ma = Math.max(ma, 1 + backtrack(s, i, set));
                set.remove(sub);
            }
        }
        return ma;
    }
    
    public int maxUniqueSplit(String s){
        Set<String> set = new HashSet<>();
        return backtrack(s, 0, set);
    }

}