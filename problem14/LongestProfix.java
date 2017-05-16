package problem14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Created by happyboy on 2017/5/13.
 */

/*Solved*/
public class LongestProfix
{
    public String longestCommonPrefix(String[] strs)
    {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];


        int charPos=0;

        StringBuilder common=new StringBuilder();

        while(true)
        {
            int strPos=0;
            for(;strPos<strs.length-1;strPos++)
                if(strs[strPos].length()<=charPos||strs[strPos+1].length()<=charPos||strs[strPos].charAt(charPos)
                        !=strs[strPos+1].charAt(charPos))
                    return common.toString();

            common.append(strs[strPos].charAt(charPos));
            charPos++;
        }
    }
}
