package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3351 👎 0


import java.util.Arrays;

//java:最长回文子串
public class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        //测试代码:
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
//public class Solution {  //解法一。暴力解法。来自大神
//
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        int maxLen = 1;
//        int begin = 0;
//        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
//        char[] charArray = s.toCharArray();
//
//        // 枚举所有长度大于 1 的子串 charArray[i..j]
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//    /**
//     * 验证子串 s[left..right] 是否为回文串
//     */
//    private boolean validPalindromic(char[] charArray, int left, int right) {
//        while (left < right) {
//            if (charArray[left] != charArray[right]) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
//public class Solution {  //解法二。暴力解法。自写一遍以及小优化
//
//    public String longestPalindrome(String s) {
//        char[] sToCharArray = s.toCharArray();
//        //startIndex和maxLen用来记录最长回文子串的位置。初始时最长回文子串是第一个字符。
//        int startIndex = 0;
//        int maxLen = 1;
//
//        for(int left = 0; left < sToCharArray.length - 1; left++){
//            for(int right = left + 1; right < sToCharArray.length; right++){
//                int len = right - left + 1;
//                if(len > maxLen && isPalindrome(sToCharArray,left,right)){
//                    maxLen = len;
//                    startIndex = left;
//                }
//            }
//        }
//        return s.substring(startIndex,startIndex + maxLen);
//    }
//    public boolean isPalindrome(char[] str, int left, int right){
//        while(left < right){
//            if(str[left] != str[right]) return false;
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
//public class Solution { //解法三。动态规划。来自大神写法,要看思路看解法四
//    public String longestPalindrome(String s) {
//        // 特判
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        int maxLen = 1;
//        int begin = 0;
//
//        // dp[i][j] 表示 s[i, j] 是否是回文串
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else { //这里else和if之间这个括号没有必要
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//
//                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//}


//public class Solution { //解法四。动态规划。自写一遍。加上一些注释
//    public String longestPalindrome(String s) {
//        char[] sToCharArray = s.toCharArray();
//        //startIndex和maxLen用来记录最长回文子串的位置。初始时最长回文子串是第一个字符。
//        int startIndex = 0;
//        int maxLen = 1;
//
//        boolean[][] dp = new boolean[sToCharArray.length][sToCharArray.length];
//        for(int i = 0; i < dp.length; i++){
//            dp[i][i] = true;
//        }
//        /**
//         * 自写的时候发下以下要点:由于只需要填二维数组dp沿对角线割开的一半的数据即可,不用整个
//         * 都填, 所以要搞清楚要填的是哪一半,如果dp的行下标表示子串的left,列下标表示子串的right,
//         * 那么由于left<=right, 填的必然是dp的右上方,而不是左下方。
//         * 其次, 由于动态转移方程是:dp[left][right] = dp[left + 1][right - 1];
//         * 所以其实隐含了对于行(left)和列(right)哪个作为内层或外层循环其实也有规定(也就是到底是一行一行遍历还是
//         * 一列一列遍历是有要求的), 由于dp[left - 1][right + 1]是dp[left][right]的左下角, 所以要求
//         * 必须要是一列一列遍历, 也就是left要作为内层循环, 否则每次访问到的dp[left + 1][right - 1]必然是默认值false。
//         */
//        for(int right = 1; right < dp.length; right++){
//            for(int left = 0; left < right; left++){
//                if(sToCharArray[left] != sToCharArray[right]) dp[left][right] = false;
//                //下面是当sToCharArray[left] == sToCharArray[right]时
//                //如果当前s[left...right]串的长度<=3,则说明它的前一级的回文子串s[left+1...right-1]
//                //要么是一个字符, 要么没有字符,而因为一个字符的串都是回文串,所以s[left...right]这种情况统一返回true。
//                else if(right -left + 1 <= 3) {
//                    dp[left][right] = true;
//                }else {
//                    dp[left][right] = dp[left + 1][right - 1]; //这里的dp[left][right]可能会是false也可能会是true。
//                }
//                if(dp[left][right] && right - left + 1 > maxLen){
//                    maxLen = right - left + 1;
//                    startIndex = left;
//                }
//            }
//        }
//        return s.substring(startIndex,startIndex + maxLen);
//    }
//}
//public class Solution { //解法五。解法四是可以优化的。可以省略单独给dp[i][i]的过程。(因为dp取的是右上角储存, 还不好改成梯子型二维数组节约空间。所以暂时放弃空间上的优化)
//    public String longestPalindrome(String s) {
//        char[] sToCharArray = s.toCharArray();
//
//        int startIndex = 0;
//        int maxLen = 1;
//
//        boolean[][] dp = new boolean[sToCharArray.length][sToCharArray.length];
//        for(int right = 0; right < dp.length; right++){
//            for(int left = 0; left <= right; left++){
//                //sToCharArray[left] != sToCharArray[right]不需要赋值,因为默认值就是false。
//                if(sToCharArray[left] == sToCharArray[right]) {
//                    if (right - left + 1 <= 3) dp[left][right] = true;
//                    else dp[left][right] = dp[left + 1][right - 1];
//                    //同时把下面的判断语句放在if(sToCharArray[left] == sToCharArray[right])的判断里(解法四没
//                    // 有这么做),因为只有在这种条件下dp[left][right]才可能为true, 可减少这个if语句的判断次数。
//                    if (dp[left][right] && right - left + 1 > maxLen) {
//                        maxLen = right - left + 1;
//                        startIndex = left;
//                    }
//                }
//
//            }
//        }
//        return s.substring(startIndex,startIndex + maxLen);
//    }
//}

//public class Solution {//解法六。中心扩散法。来自大神
//
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        String res = s.substring(0, 1);
//        // 中心位置枚举到 len - 2 即可
//        for (int i = 0; i < len - 1; i++) {
//            String oddStr = centerSpread(s, i, i);
//            String evenStr = centerSpread(s, i, i + 1);
//            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
//            if (maxLenStr.length() > maxLen) {
//                maxLen = maxLenStr.length();
//                res = maxLenStr;
//            }
//        }
//        return res;
//    }
//
//    private String centerSpread(String s, int left, int right) {
//        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
//        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
//        int len = s.length();
//        int i = left;
//        int j = right;
//        while (i >= 0 && j < len) {
//            if (s.charAt(i) == s.charAt(j)) {
//                i--;
//                j++;
//            } else {
//                break;
//            }
//        }
//        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
//        return s.substring(i + 1, j);
//    }
//}

//public class Solution {//解法七。中心扩散法。我优化版。
//
//    public String longestPalindrome(String s) {
//        int maxLen = 1;
//        int startIndex = 0;
//        // 中心位置枚举到 len - 2 即可。起始扩散点虽然不需要0作为中心位置,但需要0之后的空隙作为中心位置,所以从0开始遍历
//        for (int i = 0; i < s.length() - 1; i++) {
//            //index1和index2用来记录s的回文子串的起始位置和末端位置。
//            int[] index1 = centerSpread(s, i, i); //这表示以i为中心扩散
//            int[] index2 = centerSpread(s, i, i + 1); //这表示以i和i+1之间的空隙为中心扩散
//            int[] longIndex = index1[1]-index1[0] > index2[1] - index2[0] ?  index1 : index2;
//            if (longIndex[1] -longIndex[0] + 1 > maxLen) {
//                maxLen = longIndex[1] - longIndex[0] + 1;
//                startIndex = longIndex[0];
//            }
//        }
//        return s.substring(startIndex, startIndex + maxLen);
//    }
//
//    private int[] centerSpread(String s, int left, int right) {
//        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
//        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            } else {
//                break;
//            }
//        }
//        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(left) != s.charAt(left)，因此不能取 left，不能取 right
//        return new int[]{left + 1, right - 1};
//    }
//}

//public class Solution {//解法七。中心扩散法。再次优化。这是执行效率高的同时内存消耗最少的一版。
//        //这版主要的优化在于将index1和index2放到了函数外作为成员变量,centerSpread()方法不再频繁的
//        // 新建数组, 同时index1和index2的索引1用来存回文子串的长度而不再是末端位置。
//    //index1和index2用来记录s的回文子串的起始位置和 长度。
//    int[] index1 = new int[2];
//    int[] index2 = new int[2];
//    public String longestPalindrome(String s) {
//        int maxLen = 1;
//        int startIndex = 0;
//        // 中心位置枚举到 len - 2 即可。起始扩散点虽然不需要0作为中心位置,但需要0之后的空隙作为中心位置,所以从0开始遍历
//        for (int i = 0; i < s.length() - 1; i++) {
//            centerSpread(s, i, i); //这表示以i为中心扩散
//            centerSpread(s, i, i + 1); //这表示以i和i+1之间的空隙为中心扩散
//            int[] longIndex = index1[1] > index2[1] ? index1 : index2;
//            if (longIndex[1] > maxLen) {
//                maxLen = longIndex[1];
//                startIndex = longIndex[0];
//            }
//        }
//        return s.substring(startIndex, startIndex + maxLen);
//    }
//
//    private void centerSpread(String s, int left, int right) {
//        //flag用来标识 找到的回文子串 要存放到index1还是index2
//        int flag = right - left;
//        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
//        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            } else {
//                break;
//            }
//        }
//        //注意, 这里index数组的下标1不再用来存放回文串的末端位置, 而是用来存放回文串的长度
//        if(flag == 0) {
//            index1[0] = left + 1;
//            index1[1] = (right - 1) - (left + 1) + 1;
//        }else {
//            index2[0] = left + 1;
//            index2[1] = (right - 1) - (left + 1) + 1;
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
