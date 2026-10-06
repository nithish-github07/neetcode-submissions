class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;
        for(int num: weights){
            low = Math.max(low,num);
            high += num; 
        }

        while(low <= high){
            int mid = (low + ((high - low) / 2));
            int temp = mid;
            int d = 1;
            for(int w: weights){
                if(temp - w < 0){
                    d++;
                    temp = mid;
                }
                temp -= w;
            }

            if(d <= days){
                res = Math.min(res,mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return res;
    }
}