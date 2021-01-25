package 删除排序数组中的重复项21_1_25;

/**
 * @author ZhangSong
 * @date 2021-01-25 16:55
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        // nums是有序的，用快指针i找到所有不同数字，放到慢指针j的位置
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            if(nums[j] == nums[nums.length -1]){
                return j + 1;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int n = new Solution().removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
