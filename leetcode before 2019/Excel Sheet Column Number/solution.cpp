class Solution {
public:
    int titleToNumber(string s) {
        int result=0;
        int der=1;
        for(int i=s.length()-1;i>=0;--i)
        {
            result+=(s[i]-'A'+1)*der;
            der=der*26;
        }
        return result;
    }
};
