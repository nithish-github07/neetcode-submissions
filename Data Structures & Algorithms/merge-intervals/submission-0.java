class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int[][] res = new int[m+1][2];
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int k = 0;
        int[] prev = intervals[0];
        for(int i=1; i<m; i++){
            if(intervals[i][0] <= prev[1]){
                int start = prev[0];
                int end = Math.max(prev[1],intervals[i][1]);
                prev = new int[]{start,end};
            }
            else{
                res[k++] = prev;
                prev = intervals[i];
            }
        }

        res[k++] = prev;

        return Arrays.copyOf(res,k);
    }
}
