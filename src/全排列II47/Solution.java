package 全排列II47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhang Song
 * @date 2022/7/27 23:08
 */
public class Solution {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    back(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
  }

  public void back(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] ||  (i !=0 && nums[i] ==nums[i -1 ] && !used[i-1])) {
        continue;
      }
        list.add(nums[i]);
        used[i] = true;
        back(nums, used, list, result);
        used[i] = false;
        list.remove(list.size()-1);

    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 2,1,1};
    System.out.println(new Solution().permuteUnique(nums));
  }
}
