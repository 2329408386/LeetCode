package problem4;

/**
 * Created by happyboy on 2017/5/8.
 */

public class Median
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if(nums1.length==0&&nums2.length==0)
            throw new IllegalArgumentException("The length of two arrays should not be 0");

        // Store nums1 and nums2 sortly.
        int[] nums=new int[nums1.length+nums2.length];
        int numsPos=0;

        // Initialize the nums1[] position and nums2[] position.
        int nums1Pos=0;
        int nums2Pos=0;

        while(nums1Pos<nums1.length&&nums2Pos<nums2.length)
        {
            if(nums1[nums1Pos]<nums2[nums2Pos])
            {
                nums[numsPos++]=nums1[nums1Pos++];
            }
            else
            {
                nums[numsPos++]=nums2[nums2Pos++];
            }
        }

        while(nums1Pos<nums1.length)
        {
            nums[numsPos++]=nums1[nums1Pos++];
        }
        while(nums2Pos<nums2.length)
        {
            nums[numsPos++]=nums2[nums2Pos++];
        }


        if((nums1.length+nums2.length)%2==0)
        {
            int mid=(nums1.length+nums2.length)/2;
            return (nums[mid-1]+nums[mid])/2.0;
        }
        else
        {
            return nums[(nums1.length+nums2.length)/2];
        }
    }
}
