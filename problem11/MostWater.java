package problem11;

/**
 * Created by happyboy on 2017/5/9.
 */

/*Solved*/
public class MostWater
{
    public int maxArea(int[] height)
    {
        if(height.length<2)
            return 0;

        int firstLine=0,secondLine=height.length-1;
        int maxArea=calculateArea(height,firstLine,secondLine);

        while(firstLine<secondLine)
        {
            int curFirstLine=firstLine;
            int curSecondLine=secondLine;

            if(height[firstLine]<height[secondLine])
            {
                while(curFirstLine<height.length-1&&height[curFirstLine]<=height[firstLine])
                    curFirstLine++;
                maxArea=Math.max(maxArea,calculateArea(height,curFirstLine,secondLine));
            }
            else
            {
                while(curSecondLine>0&&height[curSecondLine]<=height[secondLine])
                    curSecondLine--;
                maxArea=Math.max(maxArea,calculateArea(height,firstLine,curSecondLine));
            }

            firstLine=curFirstLine;
            secondLine=curSecondLine;
        }



        return maxArea;
    }

    private int calculateArea(int[] height,int firstLine,int secondLine)
    {
        return (secondLine-firstLine)*(Math.min(height[firstLine],height[secondLine]));
    }
}
