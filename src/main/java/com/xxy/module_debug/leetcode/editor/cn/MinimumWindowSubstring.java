package com.xxy.module_debug.leetcode.editor.cn; 
 //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1219 👎 0


import java.util.HashMap;

public class MinimumWindowSubstring{

    public static void main(String[] args) {
         Solution solution = new MinimumWindowSubstring().new Solution();
        String x = solution.minWindow("ADOBECODEBANC", "ABC");
        System.err.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("")){
            return "";
        }
        HashMap<Character,Integer> tarMap = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tarMap.put(t.charAt(i),tarMap.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0, right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()){
            char x = s.charAt(right);
            right++;
            if (tarMap.containsKey(x)){
                window.put(x,window.getOrDefault(x,0)+1);
                if (window.get(x).equals(tarMap.get(x))){
                    valid++;
                }
            }
            while (valid == tarMap.size()){
                if (right - left < len){
                    len = right - left;
                    start = left;
                }
                char c = s.charAt(left);
                left ++ ;
                if (tarMap.containsKey(c)){
                    if (window.get(c).equals(tarMap.get(c))){
                        valid -- ;
                    }
                    window.put(c,window.getOrDefault(c,0)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}