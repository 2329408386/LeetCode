package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by happyboy on 2017/5/13.
 */

public class ThreeSum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> threeSums=new ArrayList<>(500);

        if(nums.length<3)
            return threeSums;

        List<Integer> positives=new ArrayList<>(200);
        List<Integer> negatives=new ArrayList<>(200);
        List<Integer> zeros=new ArrayList<>(100);

        // Split nums with positive, negative and zero. O(n).
        for(int numPos=0;numPos<nums.length;numPos++)
        {
            if(nums[numPos]>0)
                positives.add(nums[numPos]);
            else if(nums[numPos]<0)
                negatives.add(nums[numPos]);
            else
                zeros.add(nums[numPos]);
        }

        // O(blgb+clgc),b+c<n;
        Collections.sort(positives);
        Collections.sort(negatives);

        //1. Only 0s.
        if(zeros.size()>=3)
        {
            Integer[] temp={0,0,0};
            threeSums.add(new ArrayList<>(Arrays.asList(temp)));
        }

        //2. 1 positive, 1 negative and 1 zero
        if(zeros.size()>0)
        {
            for(int negativePos=0;negativePos<negatives.size();negativePos++)
                if(positives.contains(Math.abs(negatives.get(negativePos))))
                {
                    Integer[] temp={negatives.get(negativePos),0,Math.abs(negatives.get(negativePos))};
                    List<Integer> tempList=new ArrayList<>(Arrays.asList(temp));
                    if(!threeSums.contains(tempList))
                        threeSums.add(tempList);
                }
        }

        //3. 2 positives, 1 negative
        for(int negativePos=0;negativePos<negatives.size();negativePos++)
        {
            int positiveNum=Math.abs(negatives.get(negativePos));
            for(int positivePos=0;positivePos<positives.size();positivePos++)
            {
                if(positives.get(positivePos)>positiveNum/2)
                    break;
                else
                {
                    int toFind=positiveNum-positives.get(positivePos);

                    List<Integer> newPositives=new ArrayList<>(positives.subList(positivePos+1,positives.size()));

                    if(newPositives.contains(toFind))
                    {
                        Integer[] temp={negatives.get(negativePos),positives.get(positivePos),toFind};
                        List<Integer> tempList=new ArrayList<>(Arrays.asList(temp));
                        if(!threeSums.contains(tempList))
                            threeSums.add(tempList);
                    }
                }
            }
        }

        //4. 2 negative, 1 positive
        for(int positivePos=0;positivePos<positives.size();positivePos++)
        {
            int positiveNum=positives.get(positivePos);
            for(int negativePos=0;negativePos<negatives.size();negativePos++)
            {
                if(negatives.get(negativePos)<-positiveNum)
                    continue;
                else
                {
                    int toFind=-positiveNum-negatives.get(negativePos);

                    List<Integer> newNegatives=new ArrayList<>(negatives.subList(negativePos+1,negatives.size()));

                    if(newNegatives.contains(toFind))
                    {
                        Integer[] temp={toFind,negatives.get(negativePos),positiveNum};
                        List<Integer> tempList=new ArrayList<>(Arrays.asList(temp));
                        if(!threeSums.contains(tempList))
                            threeSums.add(tempList);
                    }
                }
            }
        }

        return threeSums;
    }

    public static void main(String[] args)
    {
        int[] test={0,0,0,0,-1,1,-1,1,2,2,-2,-2};
        new ThreeSum().threeSum(test);
    }
}
