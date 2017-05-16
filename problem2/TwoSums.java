package problem2;

public class TwoSums
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
        ListNode head=new ListNode(0);
        
        ListNode curNode=new ListNode(0);
        
        head.next=curNode;
		
        int carry=0;
        while((l1!=null)&&(l2!=null))
        {        	        	
        	
        	int tempValue=l1.val+l2.val+carry;
        	if(tempValue>=10)
        	{
        		carry=1;
        		tempValue-=10;
        	}
        	else
        		carry=0;
        	
        	//curNode.val=tempValue;
        	curNode.next=new ListNode(tempValue);
        	curNode=curNode.next;
        	
        	
        	l1=l1.next;
        	l2=l2.next;
        }
        
        if(l1==null&&l2==null)
        {
        	if(carry==1)
        	{
        		curNode.next=new ListNode(1);
        		return head.next.next;
        	}
        }
        else if(l2==null)
        {
        	while(l1!=null)
        	{
        		int tempValue=l1.val+carry;
            	if(tempValue>=10)
            	{
            		carry=1;
            		tempValue-=10;
            	}
            	else
            		carry=0;
            	
            	//curNode.val=tempValue;
            	curNode.next=new ListNode(tempValue);
            	curNode=curNode.next;
            	
            	l1=l1.next;
        	}
        }
        else
        {
        	while(l2!=null)
        	{
        		int tempValue=l2.val+carry;
            	if(tempValue>=10)
            	{
            		carry=1;
            		tempValue-=10;
            	}
            	else
            		carry=0;
            	
            	//curNode.val=tempValue;
            	curNode.next=new ListNode(tempValue);
            	curNode=curNode.next;
            	
            	l2=l2.next;
        	}
        }
        
        if (carry==1)
		{
			curNode.next=new ListNode(1);
		}
        
        return head.next.next;
    }
	
	public static void main(String[] args)
	{
		TwoSums twoSums=new TwoSums();
		
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(6);
		//l1.next.next=new ListNode(9);
		
		ListNode l2=new ListNode(7);
		l2.next=new ListNode(4);
		
		ListNode front=twoSums.addTwoNumbers(l2, l1);
		
		while(front!=null)
		{
			System.out.print(front.val);
			front=front.next;
		}
	}

}

class ListNode
{
	public int val;
	public ListNode next;
	public ListNode(int val){
		this.val=val;
	}
}
