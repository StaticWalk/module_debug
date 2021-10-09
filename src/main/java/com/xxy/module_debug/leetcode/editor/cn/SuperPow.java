package com.xxy.module_debug.leetcode.editor.cn; 
 //你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 231 - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
// Related Topics 数学 分治 
// 👍 118 👎 0

public class SuperPow{

    public static void main(String[] args) {
         Solution solution = new SuperPow().new Solution();

         int x = solution.superPow(2,new int[]{1,0});
        System.err.println(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int base = 1337;
    public int superPow(int a, int[] b) {
        a %= base;
        int result = a;

        for (int i = b.length - 1; i >= 0; i--) {

            if (b[i] > 0){
                for (int j = 0; j < b[i]; j++) {
                    result = a*a % base;
                }
            }
            for (int j = 0; j < 10; j++) {
                result = result*a % base;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}