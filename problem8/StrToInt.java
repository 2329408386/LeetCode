package problem8;

import java.math.BigInteger;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * Created by happyboy on 2017/5/9.
 */

public class StrToInt
{
    public int myAtoi(String str)
    {
        //1. When string is empty
        if(str.length()==0)
            return 0;

        //2. Split string by white spaces.
        String[] original=str.split("[\\s]+");

        str=isValid(original);

        //3. Judge if original's first element is valid. If valid, attach its value to str.
        if(str==null)
            return 0;

        // 4.Split the string by not number and signed signal.
        String[] elements=str.split("[^0-9+-]+");

        if(elements.length==0)
            return 0;

        if(!elements[0].matches("[+-]?[0-9]+[+-]*"))
            return 0;

        // Judge if the value is in integer's scope.
        BigInteger bigInteger=new BigInteger(elements[0]);
        if(bigInteger.bitLength()>=32)
        {
            if(elements[0].charAt(0)=='-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        return Integer.parseInt(elements[0]);

    }

    /**
     * Judge if original's first element is valid.
     * @param original
     * @return
     */
    private String isValid(String[] original)
    {
        if(original.length==0)
            return null;
        if(original.length==1)
        {
            if(original[0].equals(""))
                return null;
            else
                return original[0];
        }

        if(original[0].equals(""))
            return original[1];
        else
            return original[0];

    }

    public static void main(String[] args)
    {
        StrToInt strToInt=new StrToInt();

        String[] testCases={""," +045 123","    ","  -12  ","-12jk","-jk","+123jk","jk123","+-2","+-23-","-234","-2147483648",
                "abc"};

        for(int testPos=0;testPos<testCases.length;testPos++)
            System.out.println(strToInt.myAtoi(testCases[testPos]));
    }
}
