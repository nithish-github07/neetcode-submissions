class Solution {
    public double myPow(double x, int n) {
        int p = Math.abs(n);
        double res = pow(x,p);
        if(n < 0){
            return 1 / res;
        }
        return res;
    }
    public double pow(double x, int n){
        if(n == 0) return 1;
        if(x == 0) return 0;
        double half = pow(x,n/2);
        if(n % 2 == 0){
            return half * half;
        }
        else{
            return x * half * half;
        }
    }
}
