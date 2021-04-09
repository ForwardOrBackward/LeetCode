package leetcode.editor.cn;
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 408 👎 0


//java:最长重复子数组
public class P718_MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new P718_MaximumLengthOfRepeatedSubarray().new Solution();
        //测试代码:
        solution.findLength(new int[]{1,0,0,0,1}, new int[]{1,0,0,1,1});
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//解法一。暴力法
//    public int findLength(int[] A, int[] B) {
//        int maxLen = 0;
//        for(int i = 0; i < A.length; i++){
//            for(int j = 0; j < B.length; j++){
//                //关键点是下面两句, k和m都要在内层循环里赋值。
//                int k = i;
//                int m = j;
//
//                int count = 0;
//                while(k < A.length && m < B.length && A[k] == B[m]) {
//                //while(A[k] == B[m]) {  //不能用这种循环加下面在循环里面判断这种方式方式, 会造成超时。
//                    count++;
//                    k++;
//                    m++;
//                    //if(k >= A.length || m >= B.length) break;
//                }
//                if(count > maxLen) maxLen = count;
//            }
//
//        }
//        return maxLen;
//    }
//}
//class Solution {//解法二。动态规划,自写。
//    public int findLength(int[] A, int[] B) {
//        int maxLen = 0;
//        int[][] dp = new int[A.length + 1][B.length + 1];
//        for(int i = 1; i <= A.length; i++){
//            for(int j = 1; j <= B.length; j++){
//                if(A[i-1] == B[j-1]) {
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                    //将下面这条语句放在if(A[i-1] == B[j-1])里面可以减少判断
//                    if(dp[i][j] > maxLen) maxLen = dp[i][j];
//                }
//
//            }
//        }
//        return maxLen;
//    }
//}
class Solution {//解法三。动态规划,自写,用一维数组优化空间。和"最长公共子序列"的优化方式一样
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;

        int[] dp = new int[B.length + 1];
        for(int i = 1; i <= A.length; i++){
            //原先是二维数组时,dp[i][j]所需要的dp[i-1][j-1],也就是其左上角(对角)的值,肯定会由于变成
            //了一维数组, 而在更新dp[j-1]的值时而被覆盖掉,所以要用topLeft记录当前dp[j]对应的左上角的值,
            //也就是dp[j-1]的位置。而由于dp[j]的值是不断向后更新的, 所以dp[j-1]的值在更新dp[j]时已经
            //被覆盖, 所以还需要有个变量记录dp[j-1]更新之前的值,留给下一轮循环的dp[j]使用。
            int topLeft = dp[0];
            int tmp;

            for(int j = 1; j <= B.length; j++){
                tmp = dp[j];//tmp此时得到的实际上是上一轮i循环中dp[j]的值
                if(A[i-1] == B[j-1]) {
                    dp[j] = topLeft + 1;
                    if(dp[j] > maxLen) maxLen = dp[j];
                }else {//这步非常重要!!!二维数组A[i-1] != B[j-1]时可以不管,因为默认值就是0,而一维数组不相等时
                        //是要清零的, 否则不进行处理的非0的值并不是当前dp[j]的真正的值,会对后面几轮循环
                        //时的dp[j] = topLeft + 1造成影响。并且即使是最长公共子序列用一维数组后
                        //也对A[i-1] != B[j-1]时的情况作了处理,也就是说不管是什么,转换为一维数组后,
                        //不管A[i-1]是否等于B[j-1],都应该对dp[j]做处理, 以免影响后面的值。
                    dp[j] = 0;
                }
                topLeft = tmp;
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
