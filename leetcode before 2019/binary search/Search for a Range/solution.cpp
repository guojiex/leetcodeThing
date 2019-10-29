class Solution {
public:
int BinSearch(int R[], int n ,int K )
{
    
    int low = 0;
    int high = n-1;
    int mid;              //置当前查找区间上、下界的初值
    if(R[low] == K)
        {return 0;}
    //当前查找区间R[low..high]非空
    while(low <= high)
    { 
        mid = low + ((high - low)/2);//使用 (low + high) / 2 会有整数溢出的问题
        if(R[mid] == K)
        {return mid;//查找成功返回
        }
        
        if(R[mid]>K)
            high=mid-1; //继续在R[low..mid-1]中查找
        else
            low=mid+1;//继续在R[mid+1..high]中查找
    }
    return -1;//当low>high时表示查找区间为空，查找失败
}

    vector<int> searchRange(int A[], int n, int target) {
        int left=0;
        vector<int> res;
        int mid=BinSearch(A,n,target);
        if(mid==-1)
        {
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        left=mid;
        while(left-1>=0&&A[left-1]==target)
        {
            --left;
        }
        while(mid+1<=n-1&&A[mid+1]==target)
            ++mid;
        res.push_back(left);
        res.push_back(mid);
        return res;
    }
};
