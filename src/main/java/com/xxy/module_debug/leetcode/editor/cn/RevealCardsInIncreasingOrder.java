package com.xxy.module_debug.leetcode.editor.cn; 
 //牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。 
//
// 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。 
//
// 现在，重复执行以下步骤，直到显示所有卡牌为止： 
//
// 
// 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。 
// 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。 
// 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。 
// 
//
// 返回能以递增顺序显示卡牌的牌组顺序。 
//
// 答案中的第一张牌被认为处于牌堆顶部。 
//
// 
//
// 示例： 
//
// 输入：[17,13,11,2,3,5,7]
//输出：[2,13,3,11,5,17,7]
//解释：
//我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
//重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
//我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
//我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
//我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
//我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
//我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
//我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
//我们显示 17。
//由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 1000 
// 1 <= A[i] <= 10^6 
// 对于所有的 i != j，A[i] != A[j] 
// 
// Related Topics 数组 
// 👍 102 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class RevealCardsInIncreasingOrder{

    public static void main(String[] args) {
         Solution solution = new RevealCardsInIncreasingOrder().new Solution();
         int[] x = new int[]{17,13,11,2,3,5,7};
         x = solution.deckRevealedIncreasing(x);
         System.err.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public  int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] result = new int[deck.length];

        for (int i = deck.length-1; i >= 0 ; i--) {
            putElement(deck[i],result);
        }
        return result;
    }

    void putElement(int x,int[] result){
        int last = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0){
                last = i-1;
                break;
            }
        }
        if (last == -1){
            result[0] = x;
            return;
        }
        if (last == 0){
            result[1] = result[0];
            result[0] = x;
            return;
        }
        int temp = result[last];
        for (int i = last; i >= 1 ; i--) {
            result[i+1] = result[i-1];
        }
        result[0] = x;
        result[1] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}