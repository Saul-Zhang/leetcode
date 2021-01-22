package 最长有效括号21_1_22;

/**
 * @author ZhangSong
 * @date 2021-01-22 23:14
 */
public class Solution {
    public int longestValidParentheses(String s) {
        //动态规划
        //dp[i]表示以第i位结尾的字串最长括号
        //()() i-1位为‘(’,dp[i] = dp[i-2] + 2
        //"()(())" i-1位为‘)’,dp[i] = dp[i-1] + dp[i-dp[i-1] -2]

        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                if (i <= 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 2] + 2;
                }

            } else if (dp[i - 1] > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                if(i - dp[i - 1] - 2 >= 0 ){
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }else {
                    dp[i] = dp[i - 1] +  + 2;
                }

            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()())"));
    }
}
