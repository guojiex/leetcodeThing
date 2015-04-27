##Compare Version Numbers 
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
##Code
	class Solution {
    vector<int> getVersionInts(const string version)
    {
        vector<int> res;
        string temp="";
        for(int i=0;i<version.length();++i)
        {
            if(version[i]=='.')
            {
                if(temp.length()!=0)
                {
                    res.push_back(atoi(temp.c_str()));
                    temp="";
                }
            }else
                temp+=version[i];
        }
        if(!temp.empty())
            res.push_back(atoi(temp.c_str()));
        return res;
    }
	public:
    int compareVersion(string version1, string version2) {
        /*getLeftRightString(version1);
        int leftInt1=atoi(left.c_str());
        int rightInt1=right.length()==0?0:atoi(right.c_str());*/
        vector<int> v1=getVersionInts(version1);
        vector<int> v2=getVersionInts(version2);
        int size=min(v1.size(),v2.size());
        for(int i=0;i<size;++i)
            if(v1[i]<v2[i])
                return -1;
            else if(v1[i]>v2[i])
                return 1;
        
        if(v1.size()>v2.size())
        {
            for(int i=v2.size();i<v1.size();++i)
                if(v1[i]!=0)
                    return 1;
            return 0;
        }else if(v1.size()<v2.size())
        {
            for(int i=v1.size();i<v2.size();++i)
                if(v2[i]!=0)
                    return -1;
            return 0;
        }else
            return 0;
    	}
	};
##Time 
5 ms
