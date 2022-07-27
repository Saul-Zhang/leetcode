package 网络延迟时间743;

import java.util.Arrays;

/**
 * @author Zhang Song
 * @date 2022/7/26 22:30
 */
public class Solution {

  /**
   * 1.构建邻接矩阵
   * 2. 将所有节点分为
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    // 构建邻接矩阵
    int[][] matrix = new int[n + 1][n + 1];
    for (int i = 1; i < matrix.length; i++) {
      Arrays.fill(matrix[i], 7000);
      matrix[i][i] = 0;
    }
    for (int[] time : times) {
      matrix[time[0]][time[1]] = time[2];
    }

    // 保存这n个节点到第k个节点的距离
    int[] dest = new int[n + 1];
    for (int i = 1; i < dest.length; i++) {
      dest[i] = matrix[k][i];
    }

    boolean[] used = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      int index = 0;
      for (int j = 1; j <= n; j++) {
        if (!used[j] && (index == 0 || dest[index] > dest[j])) {
          index = j;
        }
      }
      used[index] = true;

      for (int j = 1; j <= n; j++) {
        dest[j] = Math.min(dest[j], dest[index] + matrix[index][j]);
      }
    }
    int asInt = Arrays.stream(dest).max().getAsInt();
    return asInt >= 7000 ? -1 : asInt;
  }

  public static void main(String[] args) {
    int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
    System.out.println(new Solution().networkDelayTime(times, 4, 2));
  }
}
