package leetcode.editor.cn;
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 58 👎 0


//java:打印从1到最大的n位数
public class P剑指_offer_17_DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_17_DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //解法一(自写)
    public int[] printNumbers(int n) {
        int count = 0;
        for(int k = n; k > 0; k--){
            count = count*10 + 9;
        }
        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i]=i+1;
        }

        return result;
    }

//    //解法二(大神解析)
//    public int[] printNumbers(int n) {
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
