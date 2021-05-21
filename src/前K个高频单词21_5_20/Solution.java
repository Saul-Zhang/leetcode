package 前K个高频单词21_5_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author zhang song
 * @date 2021/5/20 14:01
 */
public class Solution {

  public List<String> topKFrequent(String[] words, int k) {

    return Arrays.stream(words)
        .collect(Collectors.groupingBy(String::toString, TreeMap::new, Collectors.counting()))
        .entrySet().stream()
        .sorted(
            Entry.<String, Long>comparingByValue().reversed()
        ).map(Entry::getKey).collect(Collectors.toList()).subList(0, k);

  }

  public static void main(String[] args) {
    String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
    new Solution().topKFrequent(words, 1);
  }
}
