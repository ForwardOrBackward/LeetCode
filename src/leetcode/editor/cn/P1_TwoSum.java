package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9338 👎 0


import java.util.HashMap;
import java.util.Map;

//java:两数之和
public class P1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1_TwoSum().new Solution();
        //测试代码:
        System.out.println(solution.twoSum(new int[]{2,3,3},7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        //解法1
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) return new int[]{i, j};
//                }
//            }
//            return null;
//        }

        //解法2
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length; i++){
                if(map.get(target -nums[i])!=null ){
                    return new int[]{map.get(target -nums[i]),i};
                }
                map.put(nums[i],i);//这句一定要放在if语句的后面,因为如果在if前存到map里的话,key相同的值就会直接覆盖掉。
            }
            return null;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
