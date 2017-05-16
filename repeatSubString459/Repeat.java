package repeatSubString459;

import java.util.ArrayList;
import java.util.List;

/*Description: This class is used to judge if a string has its repeated parts.*/
public class Repeat
{
	public boolean repeatedSubstringPattern(String s) 
	//Judge is string s has its repeated parts.
	{
		//repetend: used to store the repetend part(this first part of the string).
		//newCharpos: used to record the new position of character found in s which equals to s.get(0).
        String repetend=Character.toString(s.charAt(0));
        int newCharPos=0;
        
        //Through this loop, will work out if s is a repeated string.
        while(true)
        {
        	//: find new position of newCharPos, if there no, it must not repeated string.
        	newCharPos=s.indexOf(s.charAt(0), newCharPos+1);
        	if(newCharPos<0)
        		return false;
        	
        	//:Get new repetend, if its length cannot be divided by s's length, then it's cannot be repetend.
        	//So just continue the loop.
        	repetend=s.substring(0,newCharPos);
        	if(s.length()%repetend.length()!=0)
        		continue;
        	
        	int curPos=newCharPos;
        	boolean isCopy=true;
        	
        	//Loop to find the repeated part in s.If there is a part which not equals, 
        	//we can know it's not repeated string, so set the isCopy=false.
        	while(curPos<s.length())
        	{
        		if(s.substring(curPos,curPos+repetend.length()).equals(repetend))
        			curPos=curPos+repetend.length();
        		else
        		{
        			isCopy=false;
        			break;
        		}
        	}
        	if(isCopy)
        		return true;
        }
    }
	
	public static void main(String[] args)
	{
		Repeat repeat=new Repeat();
		
		List<String> strings=new ArrayList<String>();
		strings.add("abcabcabc");
		strings.add("ababcc");
		strings.add("aa");
		strings.add("a");
		strings.add("aaacb");
		strings.add("abccdabccdabccdf");
		strings.add("jkjjkjkjk");
		strings.add("jkjkkjkjk");
		strings.add("jkjkjjkjkj");
		for(int i=0;i<strings.size();i++)
			System.out.println(repeat.repeatedSubstringPattern(strings.get(i)));
	}
}