class Solution {
public:
    int majorityElement(vector<int> &num) {
        int times=num.size();
        sort(num.begin(),num.end());
        return num[times/2];
    }
};
