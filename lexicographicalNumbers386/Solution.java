package lexicographicalNumbers386;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
	/*public List<Integer> lexicalOrder(int n) 
	{
        List<String> strNumbers=new ArrayList<>();
        for(int curNum=1;curNum<=n;curNum++)
        	strNumbers.add(Integer.toString(curNum));
        Collections.sort(strNumbers);
        
        //String[] strNumberArray=(String[]) strNumbers.toArray();
        
        List<Integer> numbers=new LinkedList<>();
        for(int curNum=1;curNum<=n;curNum++)
        	numbers.add(Integer.parseInt(strNumbers.get(curNum-1)));
        return numbers;
    }*/
	
	public List<Integer> lexicalOrder(int n) 
	{
		
		List<Integer> lexicoNumbers=new LinkedList<>();
		
		
		int curNum=1;
		lexicoNumbers.add(curNum);
		
		
		// O(1).
		while(curNum<=n)
		{
			curNum=curNum*10;
			lexicoNumbers.add(curNum);
		}
		
		lexicoNumbers.remove(lexicoNumbers.size()-1);
		
		// O(1).
		while(curNum>=n)
		{
			curNum=curNum/10;
		}
		
		int maxNumber=curNum*10;
		
		//System.out.println(maxNumber);
		// O(n)
		while(curNum<maxNumber-1)
		{
						
			curNum++;			
			if(curNum%1000000==0)
				lexicoNumbers.add(curNum/1000000);
			if(curNum%100000==0)
				lexicoNumbers.add(curNum/100000);
			if(curNum%10000==0)
				lexicoNumbers.add(curNum/10000);
			if(curNum%1000==0)
				lexicoNumbers.add(curNum/1000);
			if(curNum%100==0)
				lexicoNumbers.add(curNum/100);
			if(curNum%10==0)
				lexicoNumbers.add(curNum/10);
			
			if(curNum<=n)
				lexicoNumbers.add(curNum);
		}
		
		/*for(int i=1;i<=n;i++)
			if(!lexicoNumbers.contains(i))
				lexicoNumbers.add(i);*/
		
		return lexicoNumbers;
	}
	
	public static void main(String[] args)
	{
		Solution solution=new Solution();
		System.out.println(solution.lexicalOrder(49999));
	}

}
