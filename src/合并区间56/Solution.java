package 合并区间56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Zhang Song
 * @date 2022/7/8 22:11
 */
public class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }
    List<int[]> result = new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
    int[] num = new int[2];
    num[0] = intervals[0][0];
    num[1] = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= num[1]) {
        num[1] = Math.max(intervals[i][1], num[1]);
      } else {
        result.add(num);
        num = new int[2];
        num[0] = intervals[i][0];
        num[1] = intervals[i][1];
      }

      if (i == intervals.length - 1) {
        result.add(num);
      }
    }
    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
//    int[][] intervals = {{2, 5}, {1, 3}};
    int[][] intervals = {{1, 4}, {2, 3}};
//    int[][] intervals = {{1, 3}};
//    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    int[][] merge = new Solution().merge(intervals);
    System.out.println(merge);
  }

}
