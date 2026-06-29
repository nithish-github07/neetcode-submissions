class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i: stones){
            q.offer(i);
        }
        while(q.size() > 1){
            int x = q.poll();
            int y = q.poll();
            
            if(x != y){
                int val = (x < y) ? (y - x) : (x - y);
                q.offer(val);
            }
        }

        if(q.size() > 0) return q.poll();
        else return 0;
    }
}
