package com.xxy.module_debug.leetcode.editor.cn; 
 //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5667 👎 0

import org.springframework.util.StringUtils;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters{

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int x = solution.lengthOfLongestSubstring("abcabcbb");
        int y = solution.lengthOfLongestSubstring("pwwkew");
        int z = solution.lengthOfLongestSubstring("b");
//        int z = solution.lengthOfLongestSubstring("aabaab!bb");
        System.err.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        int left = 0,right = 0;
        int len = 0;
        HashMap<Character,Integer> window = new HashMap<>();

        while (right < s.length()){
            char c = s.charAt(right);
            if (window.containsKey(c)){
                left = Math.max(left,window.get(c)+1);
            }
            window.put(c,right);
            len = Math.max(len,right-left+1);
            right++;
        }

        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}