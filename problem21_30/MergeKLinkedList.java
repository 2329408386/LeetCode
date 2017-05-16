package problem21_30;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by happyboy on 2017/5/16.
 */

/*Solved*/
public class MergeKLinkedList
{
    //O(n^3)
    public ListNode mergeKLists(ListNode[] lists)
    {
        ListNode first=new ListNode(0);

        if(lists.length==0)
            return first.next;
        if(lists.length==1)
            return lists[0];

        MergeLinkedLIst linkedLIst=new MergeLinkedLIst();
        first=lists[0];

        for(int listPos=1;listPos<lists.length;listPos++)
            first=linkedLIst.mergeTwoLists(first,lists[listPos]);

        return first;
    }

    //O(nlgn)
    public ListNode mergeKList2(ListNode[] lists)
    {
        PriorityQueue<Integer> values=new PriorityQueue<>();

        for(int listPos=0;listPos<lists.length;listPos++)
        {
            while(lists[listPos]!=null)
            {
                values.add(lists[listPos].val);
                lists[listPos]=lists[listPos].next;
            }
        }

        ListNode root=new ListNode(0);
        ListNode currentNode=root;
        while(!values.isEmpty())
        {
            currentNode.next=new ListNode(values.poll());
            currentNode=currentNode.next;
        }

        return root.next;
    }

}
