package leetcode.editor.cn;
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 173 👎 0


import java.util.Arrays;

//java:n个骰子的点数
public class P剑指_offer_60_NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_60_NgeTouZiDeDianShuLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public double[] dicesProbability(int n) {
//        double[] result = new double[5*n+1];
//        for(int i = 0; i < result.length; i++){
//            result[i] = getProbability(n+i, n);
//        }
//        return result;
//    }
//    public double getProbability(int m, int n){//返回的是"n个骰子, 和为m"出现的概率。
//        if(m <= 0 || m > 6*n) return 0.0;
//        if(n == 1) return 1.0/6.0;
//        //这个递推式非常重要, 是一个概率递推公式, 也是递归的通式
//        return (getProbability(m-1,n-1) + getProbability(m-2, n-1) + getProbability(m-3, n-1) + getProbability(m-4, n-1) + getProbability(m-5, n-1) + getProbability(m-6, n-1)) / 6.0;
//    }
//}

//class Solution {//解法二。 对上面递归通式用动态规划优化,去除重复计算过程。用n维数组代替。写的不够好, 解法三的写法比较好。
//
//    public double[] dicesProbability(int n) {
//        double[][] result = new double[n][];
//        double prob = 1.0/6.0;
//        result[0] = new double[]{prob,prob,prob,prob,prob,prob};
//        for(int i = 2; i <= n; i++){
//            result[i-1] = new double[5*i+1];
//            for(int j = 0; j < 5 * i + 1; j++){
//                int index = j;
//                for(int k = 0; k < 6; k++){
//                    if(index >= 0 && index < result[i-2].length) result[i - 1][j] += result[i - 2][index];
//                    index--;
//                }
//                result[i-1][j] /= 6.0;
//            }
//        }
//        return result[n-1];
//    }
//}

//class Solution { //解法三。优化内存消耗,将一个n维数组用两个数组代替。
//    public double[] dicesProbability(int n) {
//        double[] result;
//        double[] tmp;
//        double prob = 1.0 / 6.0;
//        result = new double[]{prob, prob, prob, prob, prob, prob};
//        for (int i = 2; i <= n; i++) {
//            tmp = result;
//            result = new double[5 * i + 1];
//            for (int j = 0; j < result.length; j++) {
//                int index = j;//需要注意的是这里index被赋的值(或者说当前j的值)就是"i-1个骰子,和为m-1的概率"所在的索引下标。
//                for (int k = 0; k < 6; k++) { //这个for循环得到的是"i个骰子, 和为m"出现的概率。
//                    //需要注意的是index的第一个值(或者说当前j的值)就是"i-1个骰子,和为m-1的概率"所在的索引下标。
//                    if (index >= 0 && index < tmp.length) result[j] += tmp[index];
//                    index--;
//                }
//                result[j] /= 6.0;
//            }
//        }
//        return result;
//    }
//}
class Solution {//解法四。大神解法。
        // 和解法三的区别是解法三是 循环一次k,算一个第n个骰子的某个和出现的概率,
        // 而解法四是 循环一次k,将第n-1个骰子的某个和出现的概率A 分配给 所有"计算第n个骰子的某个和出现的概率"将会用到概率A的地方。
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0); //用了个函数填充了数组。比我的看起来美观
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    //和解法三最大的区别就是这一行。大神是每次将"n-1个骰子,值为j+n(下标为j)的概率"依
                    // 次塞入第n到下标从j开始的6个位置。所以每次都要先除以6。
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}