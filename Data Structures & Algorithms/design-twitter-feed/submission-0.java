class Twitter {
    HashMap<Integer,List<int[]>> tweetmap;
    HashMap<Integer,HashSet<Integer>> followmap;
    int count;
    public Twitter() {
        tweetmap = new HashMap<>();
        followmap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.computeIfAbsent(userId,k -> new ArrayList<>()).add(new int[]{count,tweetId});
        count--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        followmap.computeIfAbsent(userId, k -> new HashSet<>());
        followmap.get(userId).add(userId);
        for(int id: followmap.get(userId)){
            if(tweetmap.containsKey(id)){
                int ind = tweetmap.get(id).size() - 1;
                int[] arr = tweetmap.get(id).get(ind);
                minHeap.offer(new int[]{arr[0],arr[1],id,ind-1});
            }
        } 
        while(!minHeap.isEmpty() && res.size() < 10){
            int[] arr = minHeap.poll();
            int tweetid = arr[1];
            res.add(tweetid);
            int followeeid = arr[2], ind = arr[3];
            if(ind >= 0){
                int[] newarr = tweetmap.get(followeeid).get(ind);
                minHeap.offer(new int[]{newarr[0],newarr[1],followeeid,ind-1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followmap.computeIfAbsent(followerId,k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followmap.get(followerId).contains(followeeId)){
            followmap.get(followerId).remove(followeeId);
        }
    }
}
