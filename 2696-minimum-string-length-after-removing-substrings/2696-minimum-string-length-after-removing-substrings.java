class Solution{
    public int minLength(String s){
        char arr[] = new char[s.length()];
        int k = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(k == -1) arr[k++] = ch;
            else if(arr[k] == 'A' && ch == 'B') k--;
            else if(arr[k] == 'C' && ch == 'D') k--;
            else arr[++k] = ch;
        }
        return k+1;
    }
}