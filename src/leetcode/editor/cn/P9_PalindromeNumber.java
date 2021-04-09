package leetcode.editor.cn;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1424 👎 0


//java:回文数
public class P9_PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new P9_PalindromeNumber().new Solution();
        //测试代码:

    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//方法一。把整数变成字符串, 然后用双指针。
//    public boolean isPalindrome(int x) {
//        if(x < 0) return false;
//        Integer tmp = new Integer(x);
//        String xToStr = tmp.toString();
//        for(int i = 0, j = xToStr.length()-1; i < j; i++, j--){
//            if (xToStr.charAt(i) != xToStr.charAt(j)) return false;
//        }
//        return true;
//    }
//}
//class Solution { //方法二。反转整个整数
//    public boolean isPalindrome(int x) {
//        if(x < 0) return false;
//        //反转该整数
//        int xReverse = 0;
//        for(int tmp = x; tmp != 0 ; tmp /= 10){
//            xReverse = xReverse*10 + tmp%10;
//        }
//        return x==xReverse;
//    }
//}
class Solution {  //方法三。官方解法。反转一半的数字。
    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0)) return false;
        int xReverse = 0;
        while(x > xReverse){
            xReverse = xReverse*10 + x%10;
            x /= 10;
        }
        return x == xReverse || x == xReverse/10;
    }
}

//    class Solution {//方法四。方法一的另一种写法, 利用了StringBuilder特有的reverse()方法
//        public boolean isPalindrome(int x) {
//            String reversedStr = (new StringBuilder(x + "")).reverse().toString();
//            return (x + "").equals(reversedStr);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
