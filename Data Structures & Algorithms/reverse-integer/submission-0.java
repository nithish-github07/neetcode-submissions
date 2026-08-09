class Solution {
    public int reverse(int x) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;

        int res = 0;
        while(x != 0){
            int digit = x % 10;
            x = x / 10;

            if(res > MAX / 10 || (res == MAX / 10 && (digit > MAX % 10))){
                return 0;
            }
            else if(res < MIN / 10 || (res == MIN / 10 && (digit < MIN % 10))){
                return 0;
            }

            res = (res * 10) + digit;
        }
        
        return res;
    }
}
