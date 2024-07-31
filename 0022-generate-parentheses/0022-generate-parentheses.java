class Solution {
    public void Checking(List<String> a,String s,int n,int o,int c){
        if(o > n || c > o ||  s.length() > 2*n){
            return;
        }
        if(o == n && c == n && s.length() == 2*n){
            a.add(s);
        }
        Checking(a,s+"(",n,o+1,c);
        Checking(a,s+")",n,o,c+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> a = new ArrayList<>();
        Checking(a,"",n,0,0);
        return a;
    }
}