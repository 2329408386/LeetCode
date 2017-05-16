package problem10;

/**
 * Created by happyboy on 2017/5/9.
 */

public class RegularMatching
{
    public static boolean isMatch(String s, String p)
    {
        return s.matches(p);
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aa",".*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
