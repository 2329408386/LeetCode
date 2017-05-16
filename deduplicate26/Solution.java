package deduplicate26;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution
{
	public int removeDuplicates(int[] nums) 
	{
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return 1;
		
		int frontPointer=0,backPointer=1;
		while(backPointer<nums.length)
		{
			if(nums[frontPointer]==nums[backPointer])
				backPointer++;
			else
			{
				frontPointer++;
				nums[frontPointer]=nums[backPointer];
				backPointer++;
			}
		}
		
        return frontPointer+1; 
    }
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Solution solution=new Solution();
		
		Scanner input=new Scanner(new FileReader("src/deduplicate26/testCase.txt"));
		
		String line="";
		do
		{
			line=input.nextLine();
			String[] elements=line.split(" ");
			int[] testArray=new int[elements.length];
			for(int curPos=0;curPos<elements.length;curPos++)
				testArray[curPos]=Integer.parseInt(elements[curPos]);
			System.out.println(solution.removeDuplicates(testArray));
			
		} while (input.hasNext());
	}
}
