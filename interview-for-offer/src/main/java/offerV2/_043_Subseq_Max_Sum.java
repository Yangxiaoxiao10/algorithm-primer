package offerV2;

import java.util.Arrays;

/**
 * @No          v2-043,v1-031
 * @problem     连续子数组的最大和
 * @tag         数组、动态规划
 * @author      liyazhou
 * @date        2017/5/29
 *
 * <pre>
 *      输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
 *      求所有子数组的和的最大值。要求时间复杂度是 O(n)。
 * </pre>
 */
public class _043_Subseq_Max_Sum {


    /**
     * Note
     *
     * Thought
     *      1. 动态规划
     *         函数 f(i) 表示以第 i 个数字结尾的子数组的最大和
     *
     * Algorithm
     *      1. 连续子数组的最大和 maxSum 的初始值是数组的首元素，
     *         当前元素之前的资产 currSum 的初始值是数组的首元素
     *      2. 遍历[1,n)区间的数组元素，
     *             如果资产 currSum 小于0，是负资产，抛弃，设置 currSum = 0
     *             当前元素之前的资产 currSum 累加当前元素的值，结果为新的资产
     *             如果新的资产大于最大资产，则更新最大资源值为新的资产值
     */
    private static class Solution {


        public static int findMaxSumOfSubArray(int[] array){
            if (array == null) throw new RuntimeException("Invalid input. Array is null.");

            int maxSum = array[0];
            int currSum = array[0];

            for (int i = 1; i < array.length; i ++){
                // 当前元素之前的若干元素的和 currSum, if currSum < 0，表示其是负资产，不参与下一轮的计算
                if (currSum < 0) {
                    currSum = 0;
                }
                currSum += array[i];
                maxSum = Math.max(maxSum, currSum);
            }

            return maxSum;
        }


        public static void main(String[] args){
            int[][] arrays = {
                    {1, -2, 3, 10, -4, 7, 2, -15},
                    {5, -1, -3, -4, -7, -2, -15},
                    {-5, 1, -3, -4, -7, -2, -15},
                    {-5, -1, -3, -4, -7, -2, -15},
            };

            for (int i = 0; i < arrays.length; i++){
                System.out.print(Arrays.toString(arrays[i]) + ":\t");
                System.out.println(findMaxSumOfSubArray(arrays[i]));
            }
        }
    }
}
