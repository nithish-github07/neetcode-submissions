class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int ind = 0;
        for(int q: Arrays.stream(queries).sorted().toArray()){
            while(ind < intervals.length && intervals[ind][0] <= q){
                int length = intervals[ind][1] - intervals[ind][0] + 1;
                que.offer(new int[]{length,intervals[ind][1]});
                ind++;
            }
            while(!que.isEmpty() && que.peek()[1] < q){
                que.poll();
            }

            if(!que.isEmpty()){
                map.put(q,que.peek()[0]);
            }
            else{
                map.put(q,-1);
            }
        }
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            res[i] = map.get(queries[i]);
        }
        return res;
    }
}
