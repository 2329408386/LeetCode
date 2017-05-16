package minimumMove453;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MininumMoveElements
{
	public static void main(String[] args)
	{
		MininumMoveElements mininumMoveElements=new MininumMoveElements();
		
		// The test arrays.
		List<int[]> testIntegers=new ArrayList<int[]>();
		
		// The test times
		int testTimes=1;
		
		// every test array's length
		int intLength=1000;		
		
		// give every test array random values.
		Random random=new Random();
		for(int testPos=0;testPos<testTimes;testPos++)
		{
			int[] tempInt=new int[intLength];
			for(int testIntPos=0;testIntPos<intLength;testIntPos++)
				tempInt[testIntPos]=random.nextInt(1000);
			testIntegers.add(tempInt);
		}
		
		//test them
		for(int testPos=0;testPos<testIntegers.size();testPos++)
		{
			/*for(int arrayElementPos=0;arrayElementPos<intLength;arrayElementPos++)
				System.out.print((testIntegers.get(testPos))[arrayElementPos]);
			System.out.println();*/
			long nanoBegin=System.nanoTime();
			System.out.println(mininumMoveElements.minMoves(testIntegers.get(testPos)));
			long nanoEnd=System.nanoTime();
			
			double nanoDistance=1000000000;
			System.out.println((nanoEnd-nanoBegin)/nanoDistance);
		}
		
	}
	
	public int minMoves(int[] nums) 
	{
        //Using mergeSort in java.util to sort int[] nums. Ignore the process, haha.
		//O(nlogn).
		List<Integer> copy=new ArrayList<Integer>();
        for(int numsPos=0;numsPos<nums.length;numsPos++)
        	copy.add(nums[numsPos]);
        Collections.sort(copy);
        for(int copyPos=0;copyPos<copy.size();copyPos++)
        	nums[copyPos]=copy.get(copyPos);
        
        // @param times record the times increment.
        int times=0;
        while(true)
        {
        	if(isEqual(nums))
        		return times;
        	
        	int steps=getUnequalDistance(nums);
        	
        	for(int curNumPos=0;curNumPos<nums.length-1;curNumPos++)
        	{
        		nums[curNumPos]+=steps;
        	}
    		times+=steps;
        	
        	//O(n).
        	insertionSort(nums);
        	
        	/*My god, no zuo no die.
        	if(times>100000)
        	{
        		System.out.println("Don't think it's a good idea to deal with it.");
        		return 0;
        	}*/
        }
        
    }
	
	// get the distance between the first unequal position.
	// @param nums the array
	private int getUnequalDistance(int[] nums)
	{
		for(int numsPos=nums.length-1;numsPos>0;numsPos--)
			if(nums[numsPos]!=nums[numsPos-1])
				return (nums[numsPos]-nums[numsPos-1]);
		// In fact, the front part can always run
		return 0;
	}
	
	//Insertion sort array nums.
	//@param nums the arrays which needs to be sorted.
	private void insertionSort(int[] nums)
	{
		// Caution: I initialize numsPos=nums.length. Because the first (n-1) elements are 
		// relatively sorted, so I only need to check the last one.
		for(int numsPos=nums.length-1;numsPos<nums.length;numsPos++)
		{
			int curPos=numsPos;
			while(curPos>0&&nums[curPos]<nums[curPos-1])
			{
				swap(nums,curPos,curPos-1);
				curPos--;
			}
		}
	}
	
	//Swap two elements in an array
	//@param nums the array.
	//@param pos1,@param pos2 the two position which needs to swap value.
	private void swap(int[] nums,int pos1,int pos2)
	{
		int temp=nums[pos1];
		nums[pos1]=nums[pos2];
		nums[pos2]=temp;
	}
	
	//Judge if every elements in array nums are all equal.
	private boolean isEqual(int[] nums)
	{
		if(nums[0]==nums[nums.length-1])
			return true;
		else
			return false;
	}
}