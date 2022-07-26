package nowcoder.密码验证合格程序;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Zhang Song
 * @date 2022/7/26 0:05
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.length() <= 8) {
        System.out.println("NG");
        continue;
      }
      BitSet bitSet = new BitSet(4);
      Set<String> set = new HashSet<>();
      boolean innerFlag = true;
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          bitSet.set(0);
        } else if (c >= 'a' && c <= 'z') {
          bitSet.set(1);
        } else if (c >= '0' && c <= '9') {
          bitSet.set(2);
        } else {
          bitSet.set(3);
        }

        if (i < line.length() - 2) {
          if (set.contains(line.substring(i, i + 3))) {
            System.out.println("NG");
            innerFlag = false;
            break;
          } else {
            set.add(line.substring(i, i + 3));
          }
        }
      }
      if (!innerFlag) {
        continue;
      }
      if (bitSet.cardinality() < 3) {
        System.out.println("NG");
        continue;
      }
      System.out.println("OK");
    }
  }
}