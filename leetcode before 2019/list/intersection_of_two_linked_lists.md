#Intersection of Two Linked Lists 
Write a program to find the node at which the intersection of two singly linked lists begins.


	For example, the following two linked lists:

	A:          a1 → a2
	                   ↘
                     	c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
begin to intersect at node c1.
两个链表在某一个节点处开始相交，返回那个节点

##Notes:

If the two linked lists have no intersection at all, return null.

The linked lists must retain their original structure after the function returns.

You may assume there are no cycles anywhere in the entire linked structure.

Your code should preferably run in O(n) time and use only O(1) memory.
##Solution
想象一下，如果我们把两个链表拼接起来，设A是a+c,B是b+c,重合部分为c，那么以A开始，和以B开始拼接起来的链表分别是：a+c+b+c,b+c+a+c，从数量上来看，前面都是abc组成的，那么就必然会重合在c的第一个开始节点。

具体实现方法是两个pointer分别从A，B开头遍历，遇到结尾就跳到另一个链表头。如果这样都能去到链表结尾没有重合，就说明真没有重合。

code:

	class Solution {
	public:
	    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
	        if (headA==NULL||headB==NULL)   return NULL;
	        ListNode* curA=headA;
	        ListNode* curB=headB;
	        int countA=0;
	        int countB=0;
	        while(true)
	        {
	            if(curA==curB)  return curA;
	            else{
	                curA=curA->next;
	                curB=curB->next;
	            }
	            if(curA==NULL&&countA==0)
	            {
	                curA=headB;
	                ++countA;
	            }else if(curA==NULL)
	                return NULL;
	            if(curB==NULL&&countB==0)
	            {
	                curB=headA;
	                ++countB;
	            }else if(curB==NULL)
	                return NULL;
	        }
	        return NULL;
	    }
	};