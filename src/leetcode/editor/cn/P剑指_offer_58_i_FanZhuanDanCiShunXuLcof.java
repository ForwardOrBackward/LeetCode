package leetcode.editor.cn;
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 字符串 
// 👍 66 👎 0



//java:翻转单词顺序
public class P剑指_offer_58_i_FanZhuanDanCiShunXuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_58_i_FanZhuanDanCiShunXuLcof().new Solution();
        //测试代码:
        solution.reverseWords("   Hello   World!   ");
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int j = s.length()-1, i = j;
        while(i >= 0){
            while(i>=0 && s.charAt(i) != ' ') i--;
            result.append(s.substring(i+1,j+1)+" ");
            while(i>= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
//class Solution { //解法二，用s.split（）方法。
//    public String reverseWords(String s) {
//        StringBuilder result = new StringBuilder();
//        //用一个+号可以忽略字符串首尾的多个空格以及以多个空格作为切分的分隔符。或者直接使用s.split()方法，里面不带参数。
//        String[] strs = s.split(" +");
//        for(int i = strs.length - 1; i >= 0; i--){
//            result = result.append(strs[i]+" ");
//        }
//        return result.toString().trim();
//    }
//}


//leetcode submit region end(Prohibit modification and deletion)

}