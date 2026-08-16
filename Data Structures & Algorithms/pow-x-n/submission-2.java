class Solution {
    public double myPow(double x, int n) {
        long p = n;
        if(p < 0){
            x = 1 / x;
            p = -p;
        }
        return pow(x,p);
    }
    public double pow(double x, long n){
        if(n == 0) return 1;
        double half = pow(x,n/2);
        if(n % 2 == 0){
            return half * half;
        }
        else{
            return x * half * half;
        }
    }
}
