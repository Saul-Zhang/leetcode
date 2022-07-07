package 旋转图像48;

/**
 * @author Zhang Song
 * @date 2022/7/4 22:54 https://leetcode.cn/problems/rotate-image/
 */
public class Solution {

  /**
   * m[i][j] = m[j][len-i-1]
   * 先根据主对角线交换一次m[i][j] = m[j][i]
   * 再根据中线左右交换一次m[i][j] = m[i][len-j-1]
   */
  public void rotate(int[][] matrix) {
    int len = matrix.length;
    for (int i = 0; i <= len - 1; i++) {
      for (int j = 0; j <= i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; j < (len - 1) / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][len - j - 1];
        matrix[i][len - j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    new Solution().rotate(matrix);
  }
}
