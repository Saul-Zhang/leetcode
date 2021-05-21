package 找出第K大的异或坐标值21_5_19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhang song
 * @date 2021/5/20 10:50
 */
public class Solution {

  public int kthLargestValue(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] sum = new int[m + 1][n + 1];
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i][j - 1] ^ sum[i - 1][j] ^ sum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
        result.add(sum[i][j]);
      }
    }
    List<Integer> orderList = result.stream().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    return orderList.get(k - 1);
  }

}
