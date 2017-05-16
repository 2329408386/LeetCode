package twoSum167;

public class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
    	// Check validity of numbers and target.
    	if(numbers.length<2)
    		throw new IllegalArgumentException("No two sum solution");
    	
        if(target<numbers[0]||target>=(2*numbers[numbers.length-1]))
        	throw new IllegalArgumentException("No two sum solution");
    	
        
        int firstIndex=0;
        while(numbers[firstIndex]<(target/2+1)&&firstIndex<numbers.length)
        {
        	int toSearch=target-numbers[firstIndex];
        	
        	int findedIndex=binSearch(numbers, firstIndex+1, numbers.length-1, toSearch);
        	
        	if(findedIndex!=-1)
        	{
        		int[] toReturn={firstIndex+1,findedIndex+1};
        		return toReturn;
        	}
        	firstIndex++;	
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
    
    private int binSearch(int[] numbers,int start,int end,int toSearch)
    {
    	while(start<=end)
    	{
    		int middle=(start+end)/2;
    		if(numbers[middle]<toSearch)
    			start=middle+1;
    		else if(numbers[middle]>toSearch)
    			end=middle-1;
    		else
    			return middle;
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args)
	{
		;
	}
}