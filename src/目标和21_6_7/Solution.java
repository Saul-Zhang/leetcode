package 目标和21_6_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author zhang song
 * @date 2021/6/7 10:42
 */
public class Solution {
  /**
   * 1 2 3
   *
   * 1 3
   *       0
   *     1    -1             3      1          2
   *   3  -1 1   -3          7      2          6
   * 6 0 2 -4 4 -2 0 -6      15      3         14
   *                         31      4
   * 1 1
   * 3 2
   * 7 3
   */
  public int findTargetSumWays(int[] nums, int target) {
    int result = 0;
    int len = nums.length;
    int sumLen = (int) Math.pow(2, len + 1) - 1;
    int[] sum = new int[sumLen];
    for (int i = 0; i < len; i++) {
      // 0 1 2    1 3 4 5 6  2 7 8 9..  3 15 .. 4 31
      int j = (int) (Math.pow(2, i + 1) - 1);
      // 0 1 2    1 3 6  2 7 14
      int k = 2 * j;
      for (; j <= k; j++) {
        if (j % 2 == 1) {
          sum[j] = sum[j / 2] + nums[i];
        } else {
          sum[j] = sum[j / 2 - 1] - nums[i];
        }

        if(i == len -1 && sum[j] == target){
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(new Solution().findTargetSumWays(nums,1));
  }
}
