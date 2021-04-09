package leetcode.editor.cn;
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 85 👎 0



//java:左旋转字符串
public class P剑指_offer_58_-_i_i_ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_58_-_i_i_ZuoXuanZhuanZiFuChuanLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String reverseLeftWords(String s, int n) {
//
//        return s.substring(n) + s.substring(0, n);
//    }
//}
class Solution { //当面试不允许使用切片函数时用列表遍历拼接
    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder();
//        for(int i = n; i < s.length(); i++){
//            result.append(s.charAt(i));
//        }
//        for(int i = 0; i < n; i++){
//            result.append(s.charAt(i));
//        }
        //将上面两个循环通过求余运算简化。
        int length = s.length();
        for(int i = n; i < n + length; i++){
            result.append(s.charAt(i % length));
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}