package problem13;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by happyboy on 2017/5/10.
 */

public class RomanToInteger2
{
    Map<Character,Integer> pairs=new HashMap<>();

    public RomanToInteger2()
    {
        char[] romans={'I','V','X','L','C','D','M'};
        int[] values={1,5,10,50,100,500,1000};
        for(int i=0;i<romans.length;i++)
            pairs.put(romans[i],values[i]);
    }

    public int romanToInt(String s)
    {
        int sum=pairs.get(s.charAt(s.length()-1));

        for(int romanPos=0;romanPos<s.length()-1;romanPos++)
        {
            if(pairs.get(s.charAt(romanPos))<pairs.get(s.charAt(romanPos+1)))
                sum-=pairs.get(s.charAt(romanPos));
            else
                sum+=pairs.get(s.charAt(romanPos));
        }

        return sum;
    }
}
