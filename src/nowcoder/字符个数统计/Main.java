package nowcoder.字符个数统计;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author Zhang Song
 * @date 2022/7/25 23:10
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    BitSet set = new BitSet(26);
    for (int i = 0; i < line.length(); i++) {
      set.set(line.charAt(i));
    }
    System.out.println(set.cardinality());
  }

}
