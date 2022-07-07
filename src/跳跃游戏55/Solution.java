package 跳跃游戏55;

/**
 * @author Zhang Song
 * @date 2022/7/7 22:08
 */
public class Solution {

  public boolean canJump(int[] nums) {
    int point = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (point < i) {
        return false;
      }
      if (point > nums.length - 1) {
        return true;
      }
      point = Math.max(point, i + num);
    }
    return true;
  }

}
