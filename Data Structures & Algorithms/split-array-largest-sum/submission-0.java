class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;
        for(int num: nums){
            low = Math.max(low,num);
            high += num;
        }

        while(low <= high){
            int mid = low + ((high - low) / 2);
            int split = 1;
            int sum = 0;
            for(int num: nums){
                if(sum + num > mid){
                    split++;
                    sum = 0;
                }
                sum += num;
            }

            if(split <= k){
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