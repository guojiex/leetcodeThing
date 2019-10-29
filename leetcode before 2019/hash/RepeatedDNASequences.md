##problem
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
##思路
首先把ACTG映射到2个bit上，因为只有四个可能所以2bit就够用了。
A=00,C=01,G=10,T=11.这样可以节省空间
然后需要一个hashMap表示这个字符串序列是否出现过。还需要一个set记录这个序列出现了第二次。
##Solution
代码参考了网上的代码

	bool hashMap[1024*1024];//记录序列是否出现过
	class Solution {
	public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> res;
        if(s.length()<10)
            return res;
        memset(hashMap,false,sizeof(bool)*1024*1024);
        unsigned char convert[26];//映射表
        convert['A'-'A']=0;
        convert['C'-'A']=1;
        convert['G'-'A']=2;
        convert['T'-'A']=3;
        
        ///从第0个位置开始的10字序列
        int hashValue=0;
        for(int pos=0;pos<10;++pos)
        {
            hashValue<<=2;
            hashValue|=convert[s[pos]-'A'];
        }
        hashMap[hashValue]=true;
        
        unordered_set<int> strHashValue;
        for(int pos=10;pos<s.length();++pos)
        {
            hashValue<<=2;
            hashValue|=convert[s[pos]-'A'];
            hashValue&= ~(0x300000);//一开始我也不太明白这里为什么要这么写。后来发现10字序列按照我们的编码方法是占用不满整个int的，所以之前向左移了两位的那个两位依然会留在这个int里面，必须把这两个bit清除掉
            if(hashMap[hashValue]==true)
            {
                if(strHashValue.find(hashValue)==strHashValue.end())//set里面没有但是map里面有，说明这个序列出现第二次了
                {
                    res.push_back(s.substr(pos-9,10));
                    strHashValue.insert(hashValue);
                }
            }else
            {
                hashMap[hashValue]=true;
            }
        }
        return res;
    }
	};
