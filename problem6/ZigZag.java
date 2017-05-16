package problem6;

/**
 * LeetCode problem 6. get the zigzag string.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR".
 * Created by happyboy on 2017/5/8.
 */

/*Solved*/
public class ZigZag
{
    /**
     * Convert The String s to a zigzag string with numRows lines.
     * @param s: the original string
     * @param numRows: the number of rows
     * @return: the zigzag string.
     */
    public String convert(String s, int numRows)
    {
        // Check the argument
        if(s.length()<=2||numRows<2||numRows>=s.length())
            return s;

        // Store the new zigzag string
        StringBuilder zigzag=new StringBuilder();

        // Append every new line to zigzag.
        for(int charPos=0;charPos<numRows;charPos++)
        {
            zigzag.append(s.charAt(charPos));

            int curPos=charPos;
            int firstStep=(numRows-charPos-1)*2;
            int secondStep=charPos*2;

            // This loop can append a line to zigzag.
            while(curPos<s.length())
            {
                if(firstStep>0)
                {
                    curPos+=firstStep;
                    if(curPos<s.length())
                        zigzag.append(s.charAt(curPos));
                }
                if(secondStep>0)
                {
                    curPos+=secondStep;
                    if(curPos<s.length())
                        zigzag.append(s.charAt(curPos));
                }
            }

        }

        return zigzag.toString();
    }
}
/*Note: remember to refactor the procedure before submitting it next time.*/