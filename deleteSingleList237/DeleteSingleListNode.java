package deleteSingleList237;

/**
 * This class is to delete a node from a singleLinkedList.
 * @author happyboy
 *
 */
public class DeleteSingleListNode
{
	private final ListNode head;
	private int size;
	
	/**
	 * Constructors
	 */
	public DeleteSingleListNode()
	{
		
		// TODO Auto-generated constructor stub
		head=new ListNode(0);
		head.next=null;
		size=0;
		
	}
	
	/**
	 * Add a ListNode in the front.
	 */
	public void add(int toInsert)
	{
		ListNode toInsertNode=new ListNode(toInsert);
		toInsertNode.next=head.next;
		head.next=toInsertNode;
		size++;
	}
	
	/**
	 * Delete a node.
	 * @param node: the node waiting for deleting.
	 */
	public void deleteNode(ListNode node) 
	{
		if(node==null)
			throw new NullPointerException();
		
		// Find the previous node.
        ListNode preNode=head;
        while(preNode.next!=node)
        	preNode=preNode.next;
        
        // Delete that node.
        preNode.next=node.next;
        
        size--;
    }
	
	public int size()
	{
		return size;
	}
	
	/**
	 * toString
	 */
	public String toString()
	{
		String liString="";
		ListNode curNode=head.next;
		for(int index=0;index<size;index++)
		{
			liString+=curNode.val+" ";
			curNode=curNode.next;
		}
		
		return liString;
	}
	
	
	public ListNode getHead()
	{
		return head;
	}
}

class ListNode
{
	int val;
	ListNode next;
	public ListNode(int val)
	{
		// TODO Auto-generated constructor stub
		this.val=val;
	}
}