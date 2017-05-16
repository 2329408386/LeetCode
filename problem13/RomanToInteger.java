package problem13;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a Roman Number to an Integer.
 * Created by happyboy on 2017/5/10.
 */

public class RomanToInteger
{
    private String[] unitDigits={"I","II","III","IV","V","VI","VII","VIII","IX"};   // Unit Digit
    private String[] tensDigits={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};   // Tens Digit
    private String[] hundredsDigits={"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};   // Hundreds Digit
    private String[] thousandsDigit={"M","MM","MMM"};   // Thousand Digit
    private Map<String,Integer> relations=new HashMap<>();  //Store every digit's relation between integer and Roman
    // number

    // O(1).
    public RomanToInteger(){init();}

    public int romanToInt(String s)
    {
        // Store every digit's string
        StringBuilder digit=new StringBuilder();

        int sum=0;

        for(int romanPos=0;romanPos<s.length();romanPos++)
        {
            //O(1).
            digit.append(s.charAt(romanPos));

            if(relations.containsKey(digit.toString()))
            {
                if(romanPos==s.length()-1)
                {
                    sum+=relations.get(digit.toString());
                    digit.delete(0,digit.length());
                }
                else
                {
                    //System.out.println(next);
                    if(!relations.containsKey(digit.append(s.charAt(romanPos+1)).toString()))
                    {
                        digit.deleteCharAt(digit.length()-1);
                        sum+=relations.get(digit.toString());
                        digit.delete(0,digit.length());
                    }
                    else
                        digit.deleteCharAt(digit.length()-1);
                }
            }
        }

        return sum;
    }

    /**
     * Initialize relations with Roman Number and its Integers.
     */
    private void init()
    {
        relations.put("",0);

        for(int unitNum=1;unitNum<=9;unitNum++)
            relations.put(unitDigits[unitNum-1],unitNum);
        for(int tensNum=1;tensNum<=9;tensNum++)
            relations.put(tensDigits[tensNum-1],tensNum*10);
        for(int hundredsNum=1;hundredsNum<=9;hundredsNum++)
            relations.put(hundredsDigits[hundredsNum-1],hundredsNum*100);
        for(int thousandsNum=1;thousandsNum<=3;thousandsNum++)
            relations.put(thousandsDigit[thousandsNum-1],thousandsNum*1000);
    }

    public static void main(String[] args)
    {
        String[] testCases={"MMMDLXXXVI"};
        RomanToInteger romanToInteger=new RomanToInteger();
        System.out.print(romanToInteger.romanToInt(testCases[0]));
    }

}
