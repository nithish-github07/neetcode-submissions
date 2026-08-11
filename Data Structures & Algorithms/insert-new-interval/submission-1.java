class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int[][] res = new int[m+1][2];
        int k=0;
        for(int i=0; i<m; i++){
            if(newInterval[1] < intervals[i][0]){
                res[k++] = newInterval;
                for(int j=i; j<m; j++){
                    res[k++] = intervals[j];
                }
                return Arrays.copyOf(res,k);
            }
            else if(newInterval[0] > intervals[i][1]){
                res[k++] = intervals[i];
            }
            else{
                int start = Math.min(intervals[i][0],newInterval[0]);
                int end = Math.max(intervals[i][1],newInterval[1]);
                newInterval = new int[]{start,end};
            }
        }

        res[k++] = newInterval;

        return Arrays.copyOf(res,k);
    }
}
