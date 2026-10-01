class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high;
        if(x <= 1){
            high = x;
        }
        else{
            high = x / 2;
        } 

        while(low <= high){
            int mid = low + ((high - low) / 2);
            int comp = (int) x / mid;
            if(mid == comp){
                return mid;
            }
            else if(mid < comp){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
}