package 实现strStr21_1_26;


/**
 * @author ZhangSong
 * @date 2021-01-26 23:38
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < haystack.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sissippi","issipi"));
    }
}
