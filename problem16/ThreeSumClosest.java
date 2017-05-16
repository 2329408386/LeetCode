package problem16;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Created by happyboy on 2017/5/13.
 */

public class ThreeSumClosest
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);

        int minDistance=Integer.MAX_VALUE;
        int minSum=0;
        for(int numPos=0;numPos<nums.length-2;numPos++)
        {
            // Skip the same situation.
            if(numPos>0&&nums[numPos]==nums[numPos-1])
                continue;

            int secondNum=numPos+1,thirdNum=nums.length-1;

            while(secondNum<thirdNum)
            {
                int sum=nums[numPos]+nums[secondNum]+nums[thirdNum];
                if(sum==target)
                {
                    return target;
                }
                else if(sum<target)
                {
                    secondNum++;
                }
                else
                {
                    thirdNum--;
                }

                if(Math.abs(sum-target)<minDistance)
                {
                    minDistance=Math.abs(sum-target);
                    minSum=sum;
                }
            }
        }

        return minSum;
    }
}
