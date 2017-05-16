package DetectCapital520;

import java.util.ArrayList;
import java.util.List;

public class DetectCapital
{
	private boolean detectCapitalUse(String word)
	{
		if(allCapital(word)||allLowerCase(word)||firstCapital(word))
			return true;
		else
			return false;
	}
	private boolean allCapital(String word)
	{
		/*if(word.length()<=1)
			return false;*/
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)>'Z'||word.charAt(i)<'A')
				return false;
		}
		return true;
	}
	private boolean allLowerCase(String word)
	{
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)>'z'||word.charAt(i)<'a')
				return false;
		}
		return true;
	}
	private boolean firstCapital(String word)
	{
		/*if(word.length()<=1)
			return false;*/
		if(word.charAt(0)<'A'||word.charAt(0)>'Z')
			return false;
		else
		{
			for(int i=1;i<word.length();i++)
			{
				if(word.charAt(i)>='A'&&word.charAt(i)<='Z')
					return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args)
	{
		DetectCapital detectCapital=new DetectCapital();
		List<String> testStrings=new ArrayList<String>();
		testStrings.add("Capital");
		testStrings.add("GGOogle");
		testStrings.add("G");
		testStrings.add("hello");
		testStrings.add("USA");
		testStrings.add("jfkjG");
		testStrings.add("ac");
		
		for(String s:testStrings)
			System.out.println(detectCapital.detectCapitalUse(s));
	}
}