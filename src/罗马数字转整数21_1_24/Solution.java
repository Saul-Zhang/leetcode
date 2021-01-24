package 罗马数字转整数21_1_24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangSong
 * @date 2021-01-24 22:11
 */
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        //从后往前遍历，如果第i位小于第i + 1 位，则减去第i位，否则加上第i位
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = map.get(s.charAt(i));
            int last = 0;
            if (i + 1 < s.length()) {
                last = map.get(s.charAt(i + 1));
            }
            if (num < last) {
                result -= num;
            } else {
                result += num;
            }
        }
        return result;
    }
}
