package nowcoder.进制转换;

import java.util.Scanner;

/**
 * @author Zhang Song
 * @date 2022/7/25 21:59
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine();
      int res = 0;
      for (int i = 2; i < str.length(); i++) {
        int s = str.charAt(i);
        if (s > 57) {
          s -= 55;
        }else{
          s -= 48;
        }
        res += s * Math.pow(16, str.length() - i - 1);

      }
      System.out.println(res);
    }
  }

}
