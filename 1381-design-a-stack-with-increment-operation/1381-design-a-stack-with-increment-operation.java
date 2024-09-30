class CustomStack {
    int[] stk;
    int n;

    public CustomStack(int ma) {
        stk = new int[ma];
    }
    
    public void push(int x) {
        if(n < stk.length) {
        stk[n++] = x;
       }    
    }
    
    public int pop() {
        int last = -1;
        if(n > 0) {
            last = stk[--n];
            stk[n] = 0;
        }
        return last;
        
    }
    
    public void increment(int k, int val) {
        int limit = n > k ? k : n;
        for(int i = 0; i < limit; i++) {
            stk[i] += val;
        }
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */