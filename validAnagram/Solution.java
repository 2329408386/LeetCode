package validAnagram;

import java.util.HashMap;

public class Solution
{
	public boolean isAnagram(String s, String t) 
	{
		if(s.length()!=t.length())
			return false;
		
		HashMap<Character, Integer> sMap=new HashMap<>();
		HashMap<Character, Integer> tMap=new HashMap<>();
		
		// O(1).
		for(int curLetterPos=0;curLetterPos<26;curLetterPos++)
		{
			sMap.put((char)(curLetterPos+'a'), 0);
			tMap.put((char)(curLetterPos+'a'), 0);
		}
		
//		System.out.println(sMap);
//		System.out.println(tMap);
		
		// O(n).
		for(int curCharPos=0;curCharPos<s.length();curCharPos++)
		{
			sMap.replace(s.charAt(curCharPos), sMap.get(s.charAt(curCharPos))+1);
			tMap.replace(t.charAt(curCharPos), tMap.get(t.charAt(curCharPos))+1);
		}
		
//		System.out.println(sMap);
//		System.out.println(tMap);
		
        return sMap.equals(tMap);
    }
	
	public static void main(String[] args)
	{
		Solution solution=new Solution();
		System.out.println(solution.isAnagram("siu", "sui"));
	}
}
