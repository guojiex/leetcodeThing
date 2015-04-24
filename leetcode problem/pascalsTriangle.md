##problem
Pascal's Triangle Total Accepted: 42061 Total Submissions: 139230 My Submissions Question Solution 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
##solution
class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int>> result;
        for(int i=0;i<numRows;++i)
        {
            vector<int> oneRow;
            for(int index=0;index<=i;++index)
            {
                if(index==0||index==i)
                    oneRow.push_back(1);
                else 
                {
                    oneRow.push_back(result[i-1][index-1]+result[i-1][index]);
                }
            }
            result.push_back(oneRow);
        }
        return result;
    }
};
