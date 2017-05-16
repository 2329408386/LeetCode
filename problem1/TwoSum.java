package problem1;

import java.util.ArrayList;
import java.util.Collections;

public class TwoSum
{
	public int[] twoSum(int[] nums, int target) 
	{
		ArrayList<Integer> numLists=new ArrayList<>();
		for(int numPos=0;numPos<nums.length;numPos++)
			numLists.add(nums[numPos]);
		
		//Collections.sort(numLists);
		
		for(int numPos=1;numPos<numLists.size();numPos++)
		{
			//if(numLists.get(numPos)*2>target)
			//{
				for(int innerNumPos=0;innerNumPos<numPos;innerNumPos++)
					if(numLists.get(innerNumPos)+numLists.get(numPos)==target)
						return new int[]{innerNumPos,numPos};
			//}
		}
        
		return null;
    }

	public static void main(String[] args)
	{
		TwoSum twoSum=new TwoSum();
		int[] nums={2,3,7,6,13};
		int target=10;
		
		int[] indices=twoSum.twoSum(nums, target);
		
		for(int i=0;i<indices.length;i++)
			System.out.print(indices[i]+" ");
	}
}
