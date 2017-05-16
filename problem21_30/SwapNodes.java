package problem21_30;

/**
 * Created by happyboy on 2017/5/16.
 */

public class SwapNodes
{
    public ListNode swapPairs(ListNode head)
    {
        ListNode root=new ListNode(0);
        root.next=head;

        ListNode frontNode=root;
        ListNode currentNode=head;

        while (currentNode!=null&&currentNode.next!=null)
        {
            ListNode tempNode=currentNode.next;
            currentNode.next=currentNode.next.next;
            tempNode.next=currentNode;

            frontNode.next=tempNode;

            currentNode=currentNode.next;
            frontNode=frontNode.next.next;
        }

        return root.next;
    }

    public static void main(String[] args)
    {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        SwapNodes swapNodes=new SwapNodes();
        swapNodes.swapPairs(head);
    }

}
