class Solution {
public:
   		vector<int> twoSum(vector<int> &numbers, int target) {
			vector<int> ans;
			map<int, int> numbersMap;
			map<int, int>::iterator iter;
			for (int i = 0; i < numbers.size(); i++) {
				iter = numbersMap.find(target - numbers[i]);
				if (iter != numbersMap.end()) {
					ans.push_back(iter->second);
					ans.push_back(i + 1);
					break;
				} else {
					numbersMap[numbers[i]] = i + 1;
				}
			}
			return ans;
		}
};
