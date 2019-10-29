//
//  Twitter.cpp
//  twitterDesign
//
//  Created by guoskyhero on 16/6/13.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

#include "Twitter.hpp"
#include <iostream>

using namespace std;

Twitter::Twitter(){
    
}
/** Compose a new tweet. */
void Twitter::postTweet(int userId, int tweetId){
    
}
/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
vector<int> Twitter::getNewsFeed(int userId){
    vector<int> newsFeed;
    
    return newsFeed;
}
/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
void Twitter::follow(int followerId, int followeeId){
    
}
/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
void Twitter::unfollow(int followerId, int followeeId){
    
}

