package 接雨水42;

/**
 * @author zhang song
 * @date 2022/5/29 23:09
 */
public class Solution {

  /**
   * 时间复杂度太高
   */
  public int trap1(int[] height) {
    if (height.length < 3) {
      return 0;
    }
    int low = 0;
    int high = 1;
    int result = 0;
    while (true) {
      while (high < height.length && (high - low < 2 || height[high] == 0)) {
        high += 1;
      }
      while (low < height.length && height[low] == 0) {
        low += 1;
      }

      if (low == high) {
        high += 1;
      }

      if (high > height.length - 1) {
        low += 1;
        high = low + 1;
      }
      if (low >= height.length - 1) {
        return result;
      }
      result = getSubTrap(low, high, height, result);
      high += 1;
    }
  }

  /**
   * 动态规划 需要明白一点：i处能存的水的高度是i处左侧的柱子高度和i处右侧柱子高度的最小值减去i处柱子的高度
   */
  public int trap2(int[] height) {
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    int maxIndex = 0;
    for (int i = 0; i < height.length; i++) {
      maxIndex = height[maxIndex] < height[i] ? i : maxIndex;
      left[i] = maxIndex;
    }

    maxIndex = height.length - 1;
    for (int i = height.length - 1; i >= 0; i--) {
      if (height[maxIndex] < height[i]) {
        maxIndex = i;
      }
      right[i] = maxIndex;

    }

    int result = 0;
    for (int i = 0; i < height.length; i++) {

      result += Math.min(height[left[i]], height[right[i]]) - height[i];

    }
    return result;
  }

  /**
   * 单调栈 栈中保存单调递减的高度的下标，i高度大于栈顶元素高度，则从栈顶下一个元素到i之间可以存水
   */
  public int trap3(int[] height) {

    return 0;
  }

  /**
   * 双指针 左右两个指针，记录左右两个指针外侧最大值，两个指针所指地方存的水可以算出来
   */
  public int trap4(int[] height) {

    return 0;
  }


  private int getSubTrap(int low, int high, int[] height, int result) {
    int min = Math.min(height[low], height[high]);
    result += min * (high - low - 1);
    for (int i = low + 1; i < high; i++) {
      result -= Math.min(height[i], min);
      if (height[i] < min) {
        height[i] = min;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    int[] height = new int[]{4, 2, 0, 3, 2, 5};
//    int[] height = new int[]{4,9,4,5,3,2};
//    int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//    int[] height = new int[]{8, 5, 4, 1, 8, 9, 3, 0, 0};
//    int[] height = new int[]{0,0,0,2,0,8,6,7,7};

    int[] height = new int[]{4,2,3}; //1
    System.out.println(new Solution().trap2(height));


  }
}
