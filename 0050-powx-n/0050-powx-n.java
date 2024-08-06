class Solution {
    public static double myPow(double x, int n) {
        double a=pow(x,n,n);
        return a;
    }
    public static double pow(double x, int n,int  k){
        if(n==0) return 1;
        double h=pow(x,n/2,k),a=0;
        a=h*h;
        if(n%2!=0){
        a=x*a;
        }
        if(k<0 && n==k) 
        return 1/a;
        return a;
    }
}