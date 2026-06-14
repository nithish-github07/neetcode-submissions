class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a,b;
        if(nums1.length <= nums2.length){
            a = nums1; b = nums2;
        }
        else{
            a = nums2; b = nums1;
        }
        int total = a.length + b.length;
        int half = total / 2;

        int l = 0, r = a.length - 1;
        while(true){
            int i = l + (r-l)/ 2;
            int j = half - i;

            int aleft = (i > 0) ? a[i-1] : Integer.MIN_VALUE;
            int aright = (i  < a.length) ? a[i] : Integer.MAX_VALUE;
            int bleft = (j > 0) ? b[j-1] : Integer.MIN_VALUE;
            int bright = (j < b.length) ? b[j] : Integer.MAX_VALUE;

            if(aleft <= bright && bleft <= aright){
                if(total % 2 != 0){
                    return Math.min(aright,bright);
                }
                else{
                    return ((Math.max(aleft,bleft) + Math.min(aright,bright)) / 2.0);
                }
            }
            else if(aleft > bright){
                r = i - 1;
            }
            else{
                l = i + 1;
            }
        }
    }
}
