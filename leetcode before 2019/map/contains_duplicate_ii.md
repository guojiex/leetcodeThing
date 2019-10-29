#Contains Duplicate II 

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

##note
建立一个map，key是数组里面的数，value是那个元素在数组中的Index，如果查找到map中有相同的key,而且value减去现在这个数的index小于等于K,返回true；否则更新该key-value为最新找到的这个值和这个值的index


##Solution

	class Solution {
	public:
	    bool containsNearbyDuplicate(vector<int>& nums, int k) {
	        map<int,int> myMap;
	        map<int ,int >::iterator item;
	        int size=nums.size();
	        if(size==0||size==1) return false;
	        for(int i=0;i<size;++i)
	        {
	            item=myMap.find(nums[i]);
	            if(item==myMap.end())
	                myMap[nums[i]]=i;
	            else
	            {
	                if(i-item->second<=k)
	                    return true;
	                else
	                    myMap[nums[i]]=i;
	                    //myMap.insert(pair<int,int>(nums[i],i));
	            }
	        }
	        return false;
	    }
	};