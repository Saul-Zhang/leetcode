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
        if(needle.length() > haystack.length()){
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int index = 0;
            for (int j = i; j < i + needle.length() && j < haystack.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
                if (++index == needle.length()) {
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
