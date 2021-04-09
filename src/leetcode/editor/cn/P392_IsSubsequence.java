package leetcode.editor.cn;
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 409 👎 0


//java:判断子序列
public class P392_IsSubsequence{
    public static void main(String[] args) {
        Solution solution = new P392_IsSubsequence().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution { //暴力解法。这其实是贪心算法。(人容易想到的方法就是贪心算法???)
//    public boolean isSubsequence(String s, String t) {
//        if(s == null || s.equals("")) return true;
//        int count = 0;
//        for(int i = 0; i < t.length(); i++){
//            if(s.charAt(count) == t.charAt(i)) count++;
//            if(count == s.length()) return true;
//        }
//        return false;
//    }
//}
//class Solution { //解法二。贪心算法优化版
//    public boolean isSubsequence(String s, String t) {
//        int i = 0 , j = 0;
//        while(i < s.length() && j < t.length()){
//            if(s.charAt(i) == t.charAt(j)) i++;
//            j++;
//        }
//        return i == s.length();
//    }
//}
class Solution { //解法三。贪心算法优化版
    public boolean isSubsequence(String s, String t) {
        int[] dp = new int[t.length() + 1];
        for(int i = 0; i <= t.length(); i++){
            int topLeft = dp[0];
            int tmp;
            for(int j = 0; j <= s.length(); j++){
                if(char)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
