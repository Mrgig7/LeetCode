class Solution {
    public int maximumSwap(int num) {
        String n=Integer.toString(num);
        StringBuilder sb=new StringBuilder(n);
        for(int i=0; i<sb.length(); i++){
            int midx=i;
            for(int j=sb.length()-1; j>i; j--){
                if(sb.charAt(midx)<sb.charAt(j)) midx=j;  
            }  
            if(midx!=i ){
                char temp=sb.charAt(i);
                sb.setCharAt(i,sb.charAt(midx));
                sb.setCharAt(midx,temp);
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}