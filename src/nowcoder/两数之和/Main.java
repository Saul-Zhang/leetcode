package nowcoder.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Song
 * @date 2022/7/25 22:29
 */
public class Main {

  /**
   * @param numbers int整型一维数组
   * @param target  int整型
   * @return int整型一维数组
   */
  public int[] twoSum(int[] numbers, int target) {
    // write code here
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        return new int[]{map.get(target - numbers[i]) + 1, i + 1};
      } else {
        map.put(numbers[i], i);
      }
    }
    return null;
  }
}
