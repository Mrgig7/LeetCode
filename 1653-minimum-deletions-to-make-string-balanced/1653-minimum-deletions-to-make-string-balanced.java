class Solution {
    public int minimumDeletions(String s) {
        int ta = 0; 
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                ta++;
            }
        }
        
        int lb = 0; 
        int ra = ta;
        int md = ra;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                lb++;
            } else {
                ra--;
            }
            md = Math.min(md, lb + ra);
        }
        
        return md;
    }

}