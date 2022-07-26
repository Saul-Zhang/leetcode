package nowcoder.坐标移动;

import java.util.Scanner;

/**
 * @author Zhang Song
 * @date 2022/7/25 23:36
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    String[] split = line.split(";");
    int x = 0, y = 0;
    for (String s : split) {
      if ("".equals(s) || s.length() > 3) {
        continue;
      }
      char c = s.charAt(0);
      int num = 0;
      try {
        num = Integer.parseInt(s.substring(1));
      } catch (Exception e) {
        continue;
      }
      if (c == 'W') {
        y += num;
      } else if (c == 'A') {
        x -= num;
      } else if (c == 'S') {
        y -= num;
      } else if (c == 'D') {
        x += num;
      }
    }
    System.out.println(x + "," + y);
  }
}
