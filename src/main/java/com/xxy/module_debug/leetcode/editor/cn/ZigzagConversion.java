package com.xxy.module_debug.leetcode.editor.cn; 
 //将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 923 👎 0

public class ZigzagConversion{

    public static void main(String[] args) {
         Solution solution = new ZigzagConversion().new Solution();
        System.err.println(
                solution.convert("LEETCODEISHIRING",4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {

        if (numRows <= 1){
            return s;
        }

        StringBuilder result = new StringBuilder();
        int gap = 2*numRows-2;
        int group = s.length()%gap == 0 ? s.length()/gap : s.length()/gap+1;

        for (int i = 0; i < numRows; i++) {

            if (i == 0 || i == numRows-1){
                for (int j = 0; j < group; j++) {
                    if (i + j*gap < s.length()){
                        result.append(s.charAt(i + j*gap));
                    }
                }
            }else {
                for (int j = 0; j < group; j++) {
                    if (i + j*gap < s.length()){
                        result.append(s.charAt(i + j*gap));
                    }
                    if (gap - i + j*gap < s.length()){
                        result.append(s.charAt(gap - i + j*gap));
                    }
                }
            }
        }

        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}