package problem17;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 * Created by happyboy on 2017/5/14.
 */

public class PhoneNumber
{
    public List<String> letterCombinations(String digits)
    {
        LinkedList<String> letters=new LinkedList<>();

        if((digits.length()==0)||digits.matches("[2-9]*[^2-9]+[2-9]*"))
            return letters;

        letters.add("");
        String[] maps={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        String tempLetters="";
        for(int digitPos=0;digitPos<digits.length();digitPos++)
        {
            String mapLetters=maps[digits.charAt(digitPos)-'0'];
            while(letters.peek().length()<=digitPos)
            {
                tempLetters=letters.remove();
//                for(int mapLetterPos=0;mapLetterPos<mapLetters.length();mapLetterPos++)
//                    letters.add(tempLetters+mapLetters.charAt(mapLetterPos));
                for(char c:mapLetters.toCharArray())
                    letters.add(tempLetters+c);
            }
        }


        return letters;
    }
}
