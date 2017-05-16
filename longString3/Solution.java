package longString3;

import java.util.HashSet;

public class Solution
{
	public int lengthOfLongestSubstring(String s) 
	{
		if(s.length()<2)
			return s.length();
		
		HashSet<Character> subString=new HashSet<>();
		int maxLength=0;
		
		for(int outCharPos=0;outCharPos<s.length();outCharPos++)
		{
			int curSubStringLength=0;
			for(int inCharPos=outCharPos;inCharPos<s.length();inCharPos++)
			{
				if(subString.contains(s.charAt(inCharPos)))
				{
					curSubStringLength=subString.size();
					subString.clear();
					break;
				}
				else
					subString.add(s.charAt(inCharPos));
			}
			
			if(curSubStringLength>maxLength)
				maxLength=curSubStringLength;
		}
		
		return maxLength;
    }
	
	public static void main(String[] args)
	{
		Solution solution=new Solution();
		System.err.println(solution.lengthOfLongestSubstring("jbpnbwwdijklmcgabs"));
	}

}
