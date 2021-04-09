package leetcode.editor.cn;
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 404 👎 0


//java:最长公共子序列
public class P1143_LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new P1143_LongestCommonSubsequence().new Solution();
        //测试代码:

    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//解法一, 动态规划
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()+1][text2.length()+1];
//        for (int i = 1 ; i <= text1.length(); i++){
//            for(int j = 1; j <= text2.length(); j++){
//                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
//                else dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
//            }
//        }
//        return dp[text1.length()][text2.length()];
//    }
//}
//class Solution {//解法二。 依然是动态规划, 用n,m暂存字符串的length。比上面效率更高且更节省空间。
//    public int longestCommonSubsequence(String text1, String text2) {
//        int n = text1.length(), m = text2.length();
//        int[][] dp = new int[n+1][m+1];
//        for (int i = 1 ; i <= n; i++){
//            for(int j = 1; j <= m; j++){
//                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
//                else dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
//            }
//        }
//        return dp[n][m];
//    }
//}
class Solution {//解法三。 依然是动态规划, 用一维数组来代替二维数组节省空间
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] dp = new int[m+1];
        for (int i = 1 ; i <= n; i++){
            //原先是二维数组时,dp[i][j]所需要的dp[i-1][j-1],也就是其左上角(对角)的值,肯定会由于变成
            //了一维数组, 而在更新dp[j-1]的值时而被覆盖掉,所以要用topLeft记录当前dp[j]对应的左上角的值,
            //也就是dp[j-1]的位置。而由于dp[j]的值是不断向后更新的, 所以dp[j-1]的值在更新dp[j]时已经
            //被覆盖, 所以还需要有个变量记录dp[j-1]更新之前的值,留给下一轮循环的dp[j]使用。
            int topLeft = dp [0];
            int tmp;

            for(int j = 1; j <= m; j++){
                tmp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[j] = topLeft + 1;
                else dp[j] = tmp > dp[j-1] ? tmp : dp[j-1];
                topLeft = tmp;
            }
        }
        return dp[m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
