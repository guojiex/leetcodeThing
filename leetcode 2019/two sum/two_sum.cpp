//
//  two sum
//
//  Created by Jiexin Guo on 10/28/19.
//  Copyright © 2019 Jiexin Guo. All rights reserved.
//
#include <vector>
#include <map>
#include <iostream>
#include <string>
#include <sstream>

using std::cin;
using std::cout;
using std::endl;
using std::getline;
using std::map;
using std::string;
using std::stringstream;
using std::to_string;
using std::vector;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int, int> remainval_index_map;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {
            if (remainval_index_map.find(nums[i]) != remainval_index_map.end())
            {
                result.push_back(remainval_index_map[nums[i]]);
                result.push_back(i);
                break;
            }
            remainval_index_map[target - nums[i]] = i;
        }
        return result;
    }
};

string integerVectorToString(vector<int> list, unsigned long length = -1)
{
    if (length == -1)
    {
        length = list.size();
    }

    if (length == 0)
    {
        return "[]";
    }

    string result;
    for (int index = 0; index < length; index++)
    {
        int number = list[index];
        result += to_string(number) + ", ";
    }
    return "[" + result.substr(0, result.length() - 2) + "]";
}

int main()
{
    vector<int> nums = {3, 3};
    int target = 6;
    vector<int> ret = Solution().twoSum(nums, target);

    string out = integerVectorToString(ret);
    cout << out << endl;

    return 0;
}
