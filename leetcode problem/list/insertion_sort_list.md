#Insertion Sort List 

Sort a linked list using insertion sort.

##Solution
	/**
	 * Definition for singly-linked list.
	 * struct ListNode {
	 *     int val;
	 *     ListNode *next;
	 *     ListNode(int x) : val(x), next(NULL) {}
	 * };
	 */
	class Solution {
	public:
	    ListNode* insertionSortList(ListNode* head) {
	        if(!head)   return head;
	        ListNode* cur=head->next;
	        head->next=NULL;
	        while(cur!=NULL)
	        {
	            ListNode* next=cur->next;
	            if(cur->val<=head->val)
	            {
	                cur->next=head;
	                head=cur;
	                cur=next;
	                continue;
	            }
	            ListNode* temp=head;
	            ListNode* pre=NULL;
	            while(temp->next!=NULL&&cur->val>temp->val)
	            {
	                pre=temp;
	                temp=temp->next;
	            }
	            if(temp->next==NULL)//tail
	            {
	                if(cur->val<=temp->val)
	                {
	                    pre->next=cur;
	                    cur->next=temp;
	                }else
	                {
	                    temp->next=cur;
	                    cur->next=NULL;
	                }
	            }else
	            {
	                pre->next=cur;
	                cur->next=temp;
	            }
	            cur=next;
	        }
	        return head;
	    }
	};
