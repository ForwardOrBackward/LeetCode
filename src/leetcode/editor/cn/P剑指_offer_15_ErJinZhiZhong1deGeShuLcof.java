package leetcode.editor.cn;
//请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 
//2。 
//
// 示例 1： 
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 62 👎 0


//java:二进制中1的个数
public class P剑指_offer_15_ErJinZhiZhong1deGeShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_15_ErJinZhiZhong1deGeShuLcof().new Solution();
        //测试代码:
        System.out.println(solution.hammingWeight(-5));
    }    
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
//    //解法一
//    public int hammingWeight(int n) {
//        int count = 0; //count用来统计n中的1的个数
//        while(n!=0){
//            res += n&1;
//            n = n>>>1; //>>是右移运算符, >>>是无符号右移运算符。
//        }
//        return count;
//    }
    //解法二
    public int hammingWeight(int n) {
        int count = 0; //count用来统计n中的1的个数
        while(n!=0){
            //(n-1)会使二进制数字n最靠近右边的那个1变成0,此1右边的0都变成1。而n&(n-1)会使n最右边的1变为0,其余位全部保持不变
            n = n&(n-1);
            count ++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
