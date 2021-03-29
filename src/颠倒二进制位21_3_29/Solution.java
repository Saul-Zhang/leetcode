package 颠倒二进制位21_3_29;

/**
 * @author ZhangSong
 * @date 2021-03-29 22:48
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        /// 1.使用Java api
        // return Integer.reverse(n);

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (n & 1) << (32 - i) ;
            n >>= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(n >>> 1);
    }
}
