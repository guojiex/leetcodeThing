/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jiexin Guo
 */
public class Twitter {
    private Map<Integer, User> userMap = new HashMap<>();
    private int timestamp = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap.clear();
        this.timestamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!this.userMap.containsKey(userId)) {
            User user = new UserImpl(userId);
            this.userMap.put(userId, user);
        }
        this.userMap.get(userId).postTweet(new Tweet(tweetId, timestamp++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
     * in the news feed must be posted by users who the user followed or by the
     * user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> result = new PriorityQueue<>();
        if (this.userMap.containsKey(userId)) {
            User user = this.userMap.get(userId);
            result.addAll(user.getTweets());
            List<User> followers = user.getFollowed();
            followers.stream().forEach(follower -> {
                result.addAll(follower.getTweets());
            });
        }

        List<Integer> toReturn = new ArrayList<>();
        while (toReturn.size() < 10 && !result.isEmpty()) {
            toReturn.add(result.poll().getTweetId());
        }
        return toReturn;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!this.userMap.containsKey(followerId)) {
            userMap.put(followerId, new UserImpl(followerId));
        }
        if (!this.userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new UserImpl(followeeId));
        }
        userMap.get(followerId).follow(userMap.get(followeeId));
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be
     * a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (this.userMap.containsKey(followerId)) {
            this.userMap.get(followerId).unfollow(this.userMap.get(followeeId));
        }
    }

    private static class Tweet implements Comparable<Tweet> {
        private int tweetId;
        private int timestamp;

        /**
         * @param tweetId
         * @param timestamp
         */
        public Tweet(int tweetId, int timestamp) {
            super();
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }

        /**
         * @return the tweetId
         */
        protected int getTweetId() {
            return tweetId;
        }

        @Override
        public int compareTo(Tweet o) {
            return o.timestamp - this.timestamp;
        }

    }

    interface User {
        public void postTweet(Tweet tweet);

        public int getUserId();

        public List<User> getFollowed();

        public void follow(User followed);

        public void unfollow(User followed);

        public List<Tweet> getTweets();
    }

    private static class UserImpl implements User {
        private List<User> followedList = new ArrayList<>();
        private List<Tweet> tweetList = new ArrayList<>();
        private int userId;

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + userId;
            return result;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            UserImpl other = (UserImpl) obj;
            if (userId != other.userId)
                return false;
            return true;
        }

        public UserImpl(int userId) {
            this.userId = userId;
        }

        @Override
        public void postTweet(Tweet tweet) {
            this.tweetList.add(tweet);
        }

        @Override
        public int getUserId() {
            return this.userId;
        }

        @Override
        public List<User> getFollowed() {
            return new ArrayList<>(this.followedList);
        }

        @Override
        public void unfollow(User followed) {
            if (this.followedList.contains(followed)) {
                this.followedList.remove(followed);
            }
        }

        @Override
        public void follow(User follower) {
            if (!this.equals(follower) && !this.followedList.contains(follower)) {
                this.followedList.add(follower);
            }
        }

        @Override
        public List<Tweet> getTweets() {
            return new ArrayList<>(this.tweetList);
        }
    }

    public static void main(String[] args) {
        Twitter test = new Twitter();
        test.postTweet(1, 1);
        System.out.println(test.getNewsFeed(1));
        test.follow(2, 1);
        // test.postTweet(2, 6);
        System.out.println(test.getNewsFeed(2));
        test.unfollow(2, 1);
        System.out.println(test.getNewsFeed(2));
    }
}
