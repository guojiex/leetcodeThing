## Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
#code
	class Solution {
    private:
    //no matter the order of each ints 
    vector<int> getEachSingleIntOfAnInt(int n)
    {
        vector<int> res;
        while(n!=0)
        {
            res.push_back(n%10);
            n/=10;
        }
        return res;
    }
    int getSum(const vector<int> &eachInt)
    {
        int sum=0;
        for(int i=0;i<eachInt.size();++i)
            sum+=eachInt[i]*eachInt[i];
        return sum;
    }
	public:
    bool isHappy(int n) {
        set<int> s1; 
        int size=s1.size();
        while(true)
        {
            n=getSum(getEachSingleIntOfAnInt(n));
            if(n==1)
                return true;
            s1.insert(n);
            if(size==s1.size())
                return false;
            size=s1.size();
        }
    }
	};
