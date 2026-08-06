class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int xor = a ^ b;
            b = (a & b) << 1;
            a = xor;
        }
        return a;
    }
}
