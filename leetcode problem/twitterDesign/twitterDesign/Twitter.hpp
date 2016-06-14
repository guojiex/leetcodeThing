//
//  Twitter.hpp
//  twitterDesign
//
//  Created by guoskyhero on 16/6/13.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

_Pragma("once")
#include <vector>
#include <map>

class Twitter{
public:
    /** Initialize your data structure here. */
    Twitter();
    /** Compose a new tweet. */
    void postTweet(int userId, int tweetId);
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    std::vector<int> getNewsFeed(int userId);
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    void follow(int followerId, int followeeId);
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    void unfollow(int followerId, int followeeId);
private:
    map<int,int> userIdToTweetIdMap;
    
};
/* Twitter_hpp */
