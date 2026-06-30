class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char ch: tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<26; i++){
            if(freq[i] != 0) maxHeap.offer(freq[i]);
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count != 0){
                    q.offer(new int[]{count,n+time});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
             
        }

        return time;
    }
}
