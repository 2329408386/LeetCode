package problem19;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Created by happyboy on 2017/5/14.
 */

public class RemoveNode
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        int listSize=1;

        ListNode currentNode=head;
        while (currentNode.next!=null)
        {
            listSize++;
            currentNode=currentNode.next;
        }

        ListNode root=new ListNode(0);
        root.next=head;

        currentNode=root;
        int frontSize=listSize-n;
        while(frontSize-->0)
            currentNode=currentNode.next;
        currentNode.next=currentNode.next.next;

        return root.next;
    }
}

class ListNode
{
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}