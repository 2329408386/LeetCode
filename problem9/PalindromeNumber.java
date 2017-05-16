package problem9;

import java.util.HashMap;
import java.util.Map;

/**
 * Judge if an integer is palindromic number. My solution is: convert this integer to string, compare the reversed
 * string and original string. If they are equal, then they are palindromic number, they are not otherwise.
 * Created by happyboy on 2017/5/9.
 */

public class PalindromeNumber
{
    /**
     * Judge if an integer is palindromic number.
     * @param x
     * @return
     */
    public boolean isPalindrome(int x)
    {
        StringBuilder palindrome=new StringBuilder(((Integer)x).toString());

        if(palindrome.toString().equals(palindrome.reverse().toString()))
            return true;
        return false;
    }

    public static void main()
    {
        PalindromeNumber palindromeNumber=new PalindromeNumber();

        Map<Integer,Boolean> testCases=new HashMap<>();
        testCases.put(0,true);
        testCases.put(12321,true);
        testCases.put(11,true);
        testCases.put(12,false);

        for(Integer key:testCases.keySet())
        {
            if(palindromeNumber.isPalindrome(key)==testCases.get(key))
                System.out.println("true");
            else
                System.out.println("false");
        }

    }

}
