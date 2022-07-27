package com.camusbai.exercise.heap;

import java.util.*;
import java.util.stream.Collectors;

public class LC355_DesignTwitter {
    Map<Integer, User> users;
    final int FEED_SIZE = 10;
    int counter = 0;

    public LC355_DesignTwitter() {
        users = new HashMap<>();
    }

    public static void main(String[] args) {
        LC355_DesignTwitter twitter = new LC355_DesignTwitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));;
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));;
    }

    public void postTweet(int userId, int tweetId) {
        if(users.get(userId)==null) users.put(userId, new User());
        User user = users.get(userId);
        Integer[] tweet = new Integer[]{tweetId, counter++};
        user.tweets.add(tweet);
        addToNewsFeed(user.newsFeed, tweet);
        for(Integer id: user.followers) {
            addToNewsFeed(users.get(id).newsFeed, tweet);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        if(users.get(userId)==null) return Collections.emptyList();

        Queue<Integer[]> newsFeed = users.get(userId).newsFeed;
        if(newsFeed.size()<1) {
            return Collections.emptyList();
        } else{
            return newsFeed.stream().sorted((a,b) -> b[1]-a[1]).map(tweet -> tweet[0]).collect(Collectors.toList());
        }

    }

    public void follow(int followerId, int followeeId) {
        if(users.get(followerId)==null) users.put(followerId, new User());
        if(users.get(followeeId)==null) users.put(followeeId, new User());
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower.followees.contains(followeeId)) {
            return;
        }
        follower.followees.add(followeeId);
        followee.followers.add(followerId);

        // update follower's feed
        for(int i=followee.tweets.size()-1;i>-1;i--){
            Integer[] tweet = followee.tweets.get(i);
            if(follower.newsFeed.size()>=FEED_SIZE && tweet[1]<follower.newsFeed.peek()[1]) {
                break;
            } else {
                follower.newsFeed.offer(tweet);
                while(follower.newsFeed.size()>FEED_SIZE) {
                    follower.newsFeed.poll();
                }
            }
        }
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        follower.followees.remove(followeeId);
        followee.followers.remove(followerId);

        follower.newsFeed = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(Integer id:follower.followees) {
            List<Integer[]> tweets = users.get(id).tweets;
            if(tweets.size()<1) continue;
            for(Integer[] tweet: tweets) {
                addToNewsFeed(follower.newsFeed, tweet);
            }
        }

        for(Integer[] tweet: follower.tweets) {
            addToNewsFeed(follower.newsFeed, tweet);
        }
    }

    private void addToNewsFeed(Queue<Integer[]> newsFeed, Integer[] tweet) {
        if(newsFeed.size()<FEED_SIZE) {
            newsFeed.offer(tweet);
        } else if(newsFeed.peek()[1]<tweet[1]) {
            newsFeed.poll();
            newsFeed.offer(tweet);
        }
    }

    static class User{
        List<Integer[]> tweets = new ArrayList<>();
        Queue<Integer[]> newsFeed = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> followees = new HashSet<>();
        Set<Integer> followers = new HashSet<>();
    }
}
