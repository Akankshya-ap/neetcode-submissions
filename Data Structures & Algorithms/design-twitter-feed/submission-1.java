class Twitter {
    int count;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        
        int count =0;
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k->new ArrayList<>()).add(new int[]{count++, tweetId});

        if(tweets.get(userId).size()>10){
            tweets.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));

        followMap.computeIfAbsent(userId,k-> new HashSet<>()).add(userId);

        for(int followeeId: followMap.get(userId)){
            if(tweets.containsKey(followeeId)){
            List<int[]> tweet = tweets.get(followeeId);
            int index = tweet.size()-1;
            int[] t = tweet.get(index);
            pq.offer(new int[]{t[0], t[1], followeeId, index});
            }
        }

        while(!pq.isEmpty() && res.size()<10){
            int[] curr = pq.poll();
            res.add(curr[1]);

            int index = curr[3];
            if(index>0){
                int[] t = tweets.get(curr[2]).get(index-1);
                pq.offer(new int[]{t[0], t[1], curr[2], index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k,v)->{v.remove(followeeId); return v;});

    }
}
