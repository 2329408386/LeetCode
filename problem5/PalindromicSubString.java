package problem5;

/**
 * Created by happyboy on 2017/5/8.
 */

public class PalindromicSubString
{
    private int maxLength=0;
    private int lowestPos=0;

    public String longestPalindrome(String s)
    {
        if(s.length()<2)
            return s;

        for(int i=0;i<s.length()-1;i++)
        {
            // When it's odd.
            centerPalindrome(s,i,i);

            // When it's even.
            centerPalindrome(s,i,i+1);
        }

        return s.substring(lowestPos,lowestPos+maxLength);
    }

    private void centerPalindrome(String s,int lowPos,int highPos)
    {
        while (lowPos>=0&&highPos<s.length()&&s.charAt(lowPos)==s.charAt(highPos))
        {
            lowPos--;
            highPos++;
        }
        if(maxLength<highPos-lowPos-1)
        {
            this.lowestPos=lowPos+1;
            this.maxLength=highPos-lowPos-1;
        }
    }

    public static void main(String[] args)
    {
        PalindromicSubString palindromicSubString=new PalindromicSubString();

        System.out.println(palindromicSubString.longestPalindrome("ababd"));

    }
}
