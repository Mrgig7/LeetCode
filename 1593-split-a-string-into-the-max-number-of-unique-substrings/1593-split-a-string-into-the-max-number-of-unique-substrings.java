class Solution {
    public int backtrack(String s, int start, Set<String> set){
        int max = 0;
        if(start == s.length()){
            return 0;
        }
        for(int i=start+1; i<=s.length(); i++){
            String sub = s.substring(start, i);
            if(!set.contains(sub)){
                set.add(sub);
                max = Math.max(max, 1 + backtrack(s, i, set));
                set.remove(sub);
            }
        }
        return max;
    }
    
    public int maxUniqueSplit(String s){
        Set<String> set = new HashSet<>();
        return backtrack(s, 0, set);
    }
}