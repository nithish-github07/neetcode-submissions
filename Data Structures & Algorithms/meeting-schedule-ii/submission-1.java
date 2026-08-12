/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        int res = 0;

        for(int i=0; i<n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        
        Arrays.sort(start); Arrays.sort(end);

        int count = 0;
        int p = 0, q= 0;
        while(p < n){
            if(start[p] < end[q]){
                count++;
                p++;
            }
            else{
                count--;
                q++;
            }
            res = Math.max(count,res);
        }

        return res;
    }
}
