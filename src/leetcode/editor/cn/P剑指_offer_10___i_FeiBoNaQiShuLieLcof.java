package leetcode.editor.cn;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 104 👎 0



//java:斐波那契数列
public class P剑指_offer_10___i_FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_10___i_FeiBoNaQiShuLieLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {借用数组辅助空间
//    public int fib(int n) {
//        if(n == 0) return 0;
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i < n + 1; i++){
//            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
//        }
//        return dp[n];
//    }
//}
//class Solution { //大神解法，去除辅助空间。
//    public int fib(int n) {
//        int a = 0, b = 1, sum;
//        for(int i = 0; i < n; i++){
//            sum = (a + b) % 1000000007;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }
//}
class Solution { //对大神解法改良可读性。
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int a = 0, b = 1, sum = a + b;
        for(int i = 2; i < n; i++){
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;

        }
        return sum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}