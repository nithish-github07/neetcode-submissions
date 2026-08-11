class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int n = intervals.length;
        int prevEnd = intervals[0][1];
        for(int i=1; i<n; i++){
            if(intervals[i][0] < prevEnd){
                prevEnd = Math.min(prevEnd,intervals[i][1]);
                res++;
                continue;
            }
            prevEnd = intervals[i][1];
        }
        return res;
    }
}
