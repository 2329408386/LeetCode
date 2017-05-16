package problem21_30;

/**
 * Created by happyboy on 2017/5/16.
 */

public class MergeLinkedLIst
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode root=new ListNode(0);
        ListNode currentNode=root;

        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                currentNode.next=l1;
                currentNode=currentNode.next;
                l1=l1.next;
            }
            else
            {
                currentNode.next=l2;
                currentNode=currentNode.next;
                l2=l2.next;
            }
        }
        while(l1!=null)
        {
            currentNode.next=l1;
            currentNode=currentNode.next;
            l1=l1.next;
        }
        while (l2!=null)
        {
            currentNode.next=l2;
            currentNode=currentNode.next;
            l2=l2.next;
        }

        return root.next;
    }
}

class ListNode implements Comparable<ListNode>
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public int compareTo(ListNode o)
    {
        if(val<o.val)
            return -1;
        else if(val==o.val)
            return 0;
        else
            return 1;
    }
}


