package leetcode.editor.cn;
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 307 👎 0



//java:数组中数字出现的次数
public class P剑指_offer_56_-_i_ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_56_-_i_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0;//x用于做一次全员异或
        for(int num : nums){
            x ^= num;
        }
        //dev用于找到全员异或后的x的二进制形式中最低位第一个为1的位。（当然可以
        //是x的任意一个为1的二进制位，不一定是从最低位开始往前找，只是这样比较方便）
        int dev = 1;
        while((dev & x) == 0){
            dev <<= 1;
        }
        int result1 = 0, result2 = 0;
        for(int num : nums){
            if((dev & num) == 0){
                result1 ^= num;
            }else {
                result2 ^= num;
            }
        }
        return new int[]{result1, result2};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}