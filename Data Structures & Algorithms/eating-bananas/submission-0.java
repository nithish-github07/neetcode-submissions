class Solution {
    public int binarySearch(int[] piles, int h, int upper){
        int low = 1; int high = upper;
        int res = high;
        while(low <= high){
            int mid = (low + high) / 2;
            long hrs = 0;
            for(int i: piles){
                hrs += (i + mid - 1) / mid;
            }
            if(hrs <= h){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int upper = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i] > upper) upper = piles[i];
        }
        return binarySearch(piles,h,upper);
    }
}
