package leetcode.editor.cn;
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 71 👎 0


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

//java:第一个只出现一次的字符
public class P剑指_offer_50_DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_50_DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, -1);
            else map.put(ch, i);
        }
        int min = length;
        for (Map.Entry<Character, Integer> i : map.entrySet()){
            int position = i.getValue();
            if(position != -1 && position < min) min = position;
        }
        if(min == length) return ' ';
        return s.charAt(min);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}