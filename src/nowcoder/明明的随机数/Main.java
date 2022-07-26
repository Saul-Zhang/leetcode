package nowcoder.明明的随机数;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Zhang Song
 * @date 2022/7/25 23:00
 */
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(sc.nextLine()));
    }

    set.forEach(System.out::println);

  }
}
