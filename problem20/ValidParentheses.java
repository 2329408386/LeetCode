package problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by happyboy on 2017/5/15.
 */

/*Solved*/
public class ValidParentheses
{
    public boolean isValid(String s)
    {
        Map<Character,Character> parenthesesPairs=new HashMap<>();
        parenthesesPairs.put('(',')');
        parenthesesPairs.put('{','}');
        parenthesesPairs.put('[',']');

        Stack<Character> frontParentheses=new Stack<>();

        for(int charPos=0;charPos<s.length();charPos++)
        {
            if(parenthesesPairs.containsKey(s.charAt(charPos)))
                frontParentheses.add(s.charAt(charPos));
            else
            {
                if(frontParentheses.isEmpty())
                    return false;
                if((!parenthesesPairs.get(frontParentheses.peek()).equals(s.charAt
                        (charPos))))
                    return false;
                else
                    frontParentheses.pop();
            }
        }
        if(frontParentheses.isEmpty())
            return true;

        return false;
    }
}
