#Longest Increasing Subsequence 
###Question

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.
##原理
用dp，建立一个新的数组，每一个位置记录对应当前位置作为最长递增子序列的最后一位，的时候的序列长度。最后得到所有结果，再查找其中最大的序列长度，就是结果。

##Solution
	
	class Solution {
	public:
	    int lengthOfLIS(vector<int>& nums) {
	        int size=nums.size();
	        if(size==0) return 0;
	        vector<int> array;
	        array.resize(size);
	        for(int i=0;i<size;++i)
	            array[i]=1;
	        int max=1;
	        for(int i=1;i<size;++i)
	        {
	            for(int j=0;j<i;++j)
	            {
	                if(nums[i]>nums[j]&&array[j]+1>array[i])
	                    array[i]=array[j]+1;
	            }
	            if(array[i]>max)
	                max=array[i];
	        }
	        
	        return max;
	    }
	};