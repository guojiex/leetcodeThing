##Find the Duplicate Number
 

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

##Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

##思路
使用一个bitvector记录之前出现过的数字。如果新加入的数字已经存在bitvector中，说明这是duplicate number，返回

##solution
	class Solution {
	public:
    	int findDuplicate(vector<int>& nums) {
        	int* bitVector=new int[32*10000];
        	int size=nums.size();
        	for(int i=0;i<size;++i)
        	{
            	int index=nums[i]/32;
            	int offset=nums[i]%32;
            	if(bitVector[index]>>offset&1==1)
               		return nums[i];
            	else
            	    bitVector[index]|=(1<<offset);
        	}
        	return nums[size-1];
    	}
	};