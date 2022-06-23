package 山脉数组的峰顶索引21_6_15;

/**
 * @author zhang song
 * @date 2021/6/15 10:32
 */
public class Solution {

  public int peakIndexInMountainArray(int[] arr) {
    int low = 0;
    int high = arr.length;
    int mid = (low + high) / 2;
    while (true) {
      if (mid == 0 || mid == high - 1) {
        return mid;
      } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[mid] < arr[mid - 1]) {
        high = mid;
        mid = (low + high) / 2;
      } else if (arr[mid] < arr[mid + 1]) {
        low = mid;
        mid = (low + high) / 2;
      }
    }
  }

  public int peakIndexInMountainArray1(int[] arr) {
    //从[1,arr.length - 2]中查找
    int left = 1;
    int right = arr.length - 1;
    while (left < right) {
      int mid = (left + right) >>> 1;
      if (arr[mid] < arr[mid - 1]) {
        right = mid ;
      } else if (arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
//    int[] arr = {40, 48, 61, 75, 100, 99, 98, 39, 30, 1};
    int[] arr = {3, 4, 5, 1};
    System.out.println(new Solution().peakIndexInMountainArray1(arr));
  }
}
