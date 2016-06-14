//
//  main.cpp
//  twitterDesign
//
//  Created by guoskyhero on 16/6/13.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "Twitter.hpp"


int main(int argc, const char * argv[]) {
    Twitter obj;
    
    obj.postTweet(1, 5);
    std::vector<int> param_2 = obj.getNewsFeed(1);
    obj.follow(1,2);
    obj.postTweet(2, 6);
    param_2 = obj.getNewsFeed(1);
    return 0;
}
