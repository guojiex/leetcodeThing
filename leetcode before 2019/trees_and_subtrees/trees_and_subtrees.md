##Trees and Subtrees
https://www.codechef.com/problems/TRSUBTR
Input:

	5
	1
	2
	1
	2
	1
	1 2 M
	1 3 E
	2 4 E
	3 5 M
	2
	2
	1
	2
	1 2 M
	2
	1
	1
	1 2 M

Output:

	NO
	YES
##思路	
先给一棵树，然后要求接下来给出的树是否是第一棵树的子树。这里描述树的边的M代表左子树，E代表右子树。

##c++代码

	#include <iostream>
	using namespace std;
	struct node
	{
	   int val;
	   node* left=NULL;
	   node* right=NULL;
	};
	bool isTreeTheSame(node* p,node*q){
	       if(p==NULL&&q==NULL) return true;
	       if(p&&q && q->val==p->val&& isTreeTheSame(p->left,q->left)&&isTreeTheSame(p->right,q->right)) return true;
	       else return false;
	   }
	/*bool isTreeTheSame(node* tree1,node* tree2)
	{
	   if(tree1==NULL&&tree2==NULL)
	       return true;
	   if(tree1!=NULL&&tree2==NULL)
	       return false;
	   if(tree1==NULL&&tree2!=NULL)
	       return false;
	   if(tree1->left==NULL&&tree2->left!=NULL)
	       return false;
	   if(tree1->right==NULL&&tree2->right!=NULL)
	       return false;
	   if(tree1->val==tree2->val)
	   {
	       return isTreeTheSame(tree1->left,tree2->left)&&isTreeTheSame(tree1->right,tree2->right);
	   }else
	       return false;
	}*/
	int main() {
	// your code goes here
	int N1=0;
	//cout<<(NULL&1);
	cin>>N1;
	node* tree=new node[N1];
	for(int i=0;i<N1;++i)
	{
	    cin>>tree[i].val;
	}
	for(int i=0;i<N1-1;++i)
	{
	    int par,child;
	    char connection;
	    cin>>par;
	    --par;
	    cin>>child;
	    --child;
	    cin>>connection;
	    if(connection=='M')
	        tree[par].left=&tree[child];
	   else
	        tree[par].right=&tree[child];    
	}
	int M=0;cin>>M;
	int N=0;
	for(int testcase=0;testcase<M;++testcase)
	{
	    cin>>N;
	    node* tree2=new node[N];
	    for(int i=0;i<N;++i)
	   	{
	        cin>>tree2[i].val;
	    }
	    for(int i=0;i<N-1;++i)
	    {
	        int par,child;
	        char connection;
	        cin>>par;
	        --par;
	        cin>>child;
	        --child;
	        cin>>connection;
	        if(connection=='M')
	        {
	            tree2[par].left=&tree2[child];
	        }
	        else
	            tree2[par].right=&tree2[child];    
	    }
	    bool yes=false;
	    for(int i=0;i<N1;++i)
	    {
	        if(isTreeTheSame(&tree[i],&tree2[0]))
	        {
	            yes=true;
	            break;
	        }
	    }
	    if(yes)
	        cout<<"YES"<<endl;
	    else
	        cout<<"NO"<<endl;
	    delete [] tree2;
	}
	delete [] tree;
	return 0;
	}
