/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        //find peak
        int n = arr.length();
        int low = 1, high = n - 2;
        int peak = -1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(arr.get(mid) < arr.get(mid + 1)){
                low = mid + 1;
            }
            else if(arr.get(mid) < arr.get(mid - 1)){
                high = mid - 1;
            }
            else{
                peak = mid;
                break;
            }
        }

        //binary search - left part
        low = 0; high = peak;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(arr.get(mid) == target){
                return mid;
            }
            else if(arr.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        //binary search - right part
        low = peak + 1; high = n-1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(arr.get(mid) == target){
                return mid;
            }
            else if(arr.get(mid) < target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}