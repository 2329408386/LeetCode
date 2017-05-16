package problem7;

import java.math.BigInteger;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * Created by happyboy on 2017/5/9.
 */

public class ReverseInteger
{
    /**
     * Reverse an integer.
     * @param x
     * @return the reversed integer.
     */
    public int reverse(int x)
    {
        // Convert integer to string
        String xString=((Integer)(x)).toString();

        boolean isNegative=false;

        // Judge if the integer is negative.
        if(xString.charAt(0)=='-')
            isNegative=true;

        BigInteger reverseValue=new BigInteger("0");

        if(isNegative)
        {
            StringBuilder reversed=new StringBuilder(xString.substring(1,xString.length()));
            reverseValue=reverseValue.add(new BigInteger(reversed.reverse().toString()));
            reverseValue=reverseValue.negate();
        }
        else
        {
            StringBuilder reversed=new StringBuilder(xString);
            reverseValue=reverseValue.add(new BigInteger(reversed.reverse().toString()));
        }

        // Judge if the value is out of range.
        if(reverseValue.bitLength()>=32)
            return 0;

        return reverseValue.intValue();
    }

    public static void main(String[] args)
    {
        ReverseInteger reverseInteger=new ReverseInteger();
        int[] testCases={-321,0,234567,1234567899,120,-1234567899};

        for(int testPos=0;testPos<testCases.length;testPos++)
            System.out.println(reverseInteger.reverse(testCases[testPos]));

        //! Test
//        BigInteger big=new BigInteger("123");
//        System.out.println(big.negate());
    }
}
