package leetcode;

public class AddTwoNumbers {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2!=null)  return l2;
        if(l1!=null&&l2==null)  return l1;
        ListNode head=null;
        ListNode cur=null;
        int carry=0;
        while(l1!=null||l2!=null){
            
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            if(head==null){
                head=new ListNode(carry%10);
                cur=head;
            }else{
                cur.next=new ListNode(carry%10);
                cur=cur.next;
            }
            carry/=10;      
        }
        while(carry!=0){
            cur.next=new ListNode(carry%10);
            cur=cur.next;
            carry/=10; 
        }
        return head;
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
