package 数组中两个数的最大异或值21_5_18;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang song
 * @date 2021/5/18 11:41
 */
public class Solution {

  public int findMaximumXOR(int[] nums) {
    int x = 0;
    //set存放nums中每个元素从第30位到第i位的二进制

    // 每次确定一位
    for (int i = 30; i >= 0; i--) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        // num是31位，如果右移30得到的就是最高位
        set.add(num >> i);
      }
      x = x << 1;
      // x先左移一位再加一，就是假设x的第i位为1
      int tempX = x + 1;
      for (Integer num : set) {
        if (set.contains(tempX ^ num)) {
          // 如果找到了说明x的第i位是1，把tempX赋给x
          //否则就是x只左移，没有加1，就是x的第i位为0
          x = tempX;
          break;
        }
      }
    }
    return x;
  }

  public static void main(String[] args) {
    int[] nums = {3, 10, 5, 25, 2, 8};
    System.out.println(new Solution().findMaximumXOR(nums));
  }
}
