package problem18;

import java.util.*;

/**
 * Created by happyboy on 2017/5/14.
 */

public class FourSum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> pairs=new LinkedList<>();

        if(nums.length<4)
            return pairs;

        Arrays.sort(nums);
//        Set<int[]> visited=new HashSet<>();

        for(int firstPos=0;firstPos<nums.length-3;firstPos++)
        {
            if(firstPos>0&&nums[firstPos]==nums[firstPos-1])
                continue;
            for(int secondPos=firstPos+1;secondPos<nums.length-2;secondPos++)
            {
                if(secondPos>firstPos+1&&nums[secondPos]==nums[secondPos-1])
                    continue;
//                int[] firstTwoValue={nums[firstPos],nums[secondPos]};
//                if(isIn(visited,firstTwoValue))
//                    continue;
//                else
//                    visited.add(firstTwoValue);

                int thirdPos=secondPos+1,fourPos=nums.length-1;
                while (thirdPos<fourPos)
                {
                    int tempSum=nums[firstPos]+nums[secondPos]+nums[thirdPos]+nums[fourPos];
                    if(tempSum==target)
                    {
                        pairs.add(Arrays.asList(nums[firstPos], nums[secondPos], nums[thirdPos], nums[fourPos]));
                        thirdPos++;fourPos--;

                        while (thirdPos < nums.length  && nums[thirdPos] == nums[thirdPos - 1])
                            thirdPos++;
                        while (fourPos >= 0 && nums[fourPos] == nums[fourPos + 1])
                            fourPos--;
                    }
                    else if(tempSum<target)
                        thirdPos++;
                    else
                        fourPos--;
                }
            }
        }

        return pairs;
    }

//    private boolean isIn(Set<int[]> visited,int[] firstTwoValue)
//    {
//        for(int[] key:visited)
//            if(key[0]==firstTwoValue[0]&&key[1]==firstTwoValue[1])
//                return true;
//        return false;
//    }

    public static void main(String[] args)
    {
        FourSum fourSum=new FourSum();
        int[] test={-3,-3,-3,-3,-2,-2,0,0,0,0,0,2,2,3,3,3,4};
        fourSum.fourSum(test,0);
    }

}
