package 在排序数组中查找元素的第一个和最后一个位置21_1_28;

/**
 * @author ZhangSong
 * @date 2021-01-28 23:42
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int len = nums.length;
        if (len == 0 || nums[0] > target || nums[len - 1] < target) {
            return result;
        }

        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                if (flag) {
                    result[0] = i;
                    flag = false;
                }
            }
            if (!flag && nums[i] != target) {
                result[1] = i - 1;
                break;
            }
        }

        if ((len == 1 && nums[0] == target)) {
            result[1] = 0;
        }

        if (nums[len - 1] == target) {
            result[1] = len - 1;
        }
        return result;
    }
}
