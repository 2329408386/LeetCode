package minimumMove453;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class MinimumMoveElements2
{
	public static void main(String[] args)
	{
		MinimumMoveElements2 mininumMoveElements=new MinimumMoveElements2();
		
		// The test arrays.
		List<int[]> testIntegers=new ArrayList<int[]>();
		
		// The test times
		int testTimes=10;
		
		// every test array's length
		int intLength=3;		
		
		// give every test array random values.
		Random random=new Random();
		for(int testPos=0;testPos<testTimes;testPos++)
		{
			int[] tempInt=new int[intLength];
			for(int testIntPos=0;testIntPos<intLength;testIntPos++)
				tempInt[testIntPos]=random.nextInt(10);
			testIntegers.add(tempInt);
		}
		
		//test them
		for(int testPos=0;testPos<testIntegers.size();testPos++)
		{
			for(int arrayElementPos=0;arrayElementPos<intLength;arrayElementPos++)
				System.out.print((testIntegers.get(testPos))[arrayElementPos]);
			System.out.println();
			//long nanoBegin=System.nanoTime();
			System.out.println(mininumMoveElements.minMoves(testIntegers.get(testPos)));
			//long nanoEnd=System.nanoTime();
			
			//double nanoDistance=1000000000;
			//System.out.println((nanoEnd-nanoBegin)/nanoDistance);
		}
	}
	
	// I should remember one thing only: this is a math problem, math problem, yes.
	public int minMoves(int[] nums) 
	{
	    int originSum=IntStream.of(nums).sum();
	    
	    int minSum=nums[0];
	    for(int i=1;i<nums.length;i++)
	    	if(nums[i]<minSum)
	    		minSum=nums[i];
	    
	    return (originSum-(minSum*(nums.length)));
	}
}