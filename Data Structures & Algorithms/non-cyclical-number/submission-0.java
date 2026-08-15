//fast and slow pointers - soln
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = sumOfSquares(n);
        while(fast != 1 && slow != fast){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }
    public int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}
