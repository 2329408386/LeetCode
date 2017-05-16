package deleteSingleList237;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DeleteStringListNodeTester
{
	DeleteSingleListNode testNodes;
	
	@Before
	public void setup()
	{
		testNodes=new DeleteSingleListNode();
		int SIZE=10;
		
		for(int index=0;index<SIZE;index++)
			testNodes.add(index);
	}
	
	@Test 
	public void testDelete()
	{
		testNodes.deleteNode(testNodes.getHead().next.next.next);
		System.out.println(testNodes);
	}
}