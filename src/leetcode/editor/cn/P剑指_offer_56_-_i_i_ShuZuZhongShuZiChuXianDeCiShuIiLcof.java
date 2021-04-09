package leetcode.editor.cn;
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 128 👎 0


import java.util.HashMap;
import java.util.Map;

//java:数组中数字出现的次数 II
public class P剑指_offer_56_-_i_i_ShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_56_-_i_i_ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//解法一。用HashMap。
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num, map.getOrDefault(num,0)+1);
//        }
//        for(Map.Entry<Integer, Integer> i : map.entrySet()){
//            if(i.getValue() == 1) return i.getKey();
//        }
//        return -1;
//    }
//}

class Solution {//解法二。
    public int singleNumber(int[] nums) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}