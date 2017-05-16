package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by happyboy on 2017/5/13.
 */

public class ThreeSum2
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> threeSums=new ArrayList<>(10000);

        if(nums.length<3)
            return threeSums;

        Arrays.sort(nums);

        for(int numPos=0;numPos<nums.length-2&&nums[numPos]<=0;numPos++)
        {
            // Skip the same situation.
            if(numPos>0&&nums[numPos]==nums[numPos-1])
                continue;

            int secondNum=numPos+1,thirdNum=nums.length-1;

            while(secondNum<thirdNum)
            {
                if(nums[numPos]+nums[secondNum]+nums[thirdNum]==0)
                {
                    threeSums.add(Arrays.asList(nums[numPos],nums[secondNum],nums[thirdNum]));
                    secondNum++;thirdNum--;

                    while(nums[secondNum]==nums[secondNum-1])
                        secondNum++;
                    while(nums[thirdNum]==nums[thirdNum+1])
                        thirdNum--;
                }
                else if(nums[numPos]+nums[secondNum]+nums[thirdNum]<0)
                    secondNum++;
                else
                    thirdNum--;
            }
        }

        return threeSums;
    }

    public static void main(String[] args)
    {
        int[] test={-1,0,1,2,-1,-4};
        ThreeSum2 threeSum2=new ThreeSum2();
        threeSum2.threeSum(test);
    }

}
